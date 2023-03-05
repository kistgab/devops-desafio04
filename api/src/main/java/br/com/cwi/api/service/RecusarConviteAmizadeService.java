package br.com.cwi.api.service;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarAmizadeService;
import br.com.cwi.api.validator.UsuarioLogadoPertenceAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecusarConviteAmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private BuscarAmizadeService buscarAmizadeService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioLogadoPertenceAmizadeValidator usuarioLogadoPertenceAmizadeValidator;


    public void recusar(Long id) {
        Amizade amizade = buscarAmizadeService.porId(id);

        Usuario usuario = amizade.getUsuario();
        Usuario amigo = amizade.getAmigo();

        Usuario usuarioLogado = usuarioAutenticadoService.get();

        usuarioLogadoPertenceAmizadeValidator.validar(usuarioLogado, amizade);

        usuario.cancelarConviteAmizade(amizade);
        amigo.excluirConviteAmizade(amizade);

        amizadeRepository.delete(amizade);
    }
}
