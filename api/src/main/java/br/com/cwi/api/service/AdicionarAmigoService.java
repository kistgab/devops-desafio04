package br.com.cwi.api.service;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import br.com.cwi.api.service.core.NowService;
import br.com.cwi.api.service.core.ValidaAmizadeExistenteService;
import br.com.cwi.api.validator.UsuarioDiferenteAdicionarAmigoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.domain.StatusAmizade.PENDENTE;

@Service
public class AdicionarAmigoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioDiferenteAdicionarAmigoValidator usuarioDiferenteAdicionarAmigoValidator;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private NowService nowService;

    @Autowired
    private ValidaAmizadeExistenteService validaAmizadeExistenteService;

    public void adicionar(Long amigoId) {

        Usuario usuario = usuarioAutenticadoService.get();
        Usuario amigo = buscarUsuarioService.porId(amigoId);

        usuarioDiferenteAdicionarAmigoValidator.validar(usuario, amigo);
        validaAmizadeExistenteService.validar(usuario.getId(), amigo.getId());

        Amizade amizade = new Amizade();
        amizade.setStatus(PENDENTE);
        amizade.setDataAmizade(nowService.getDate());

        usuario.enviarConviteAmizade(amizade);
        amigo.receberConviteAmizade(amizade);

        amizadeRepository.save(amizade);
    }
}
