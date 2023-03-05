package br.com.cwi.api.service;

import br.com.cwi.api.domain.Curtida;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.CurtidaRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.service.core.NowService;
import br.com.cwi.api.service.core.ValidaAmizadeExistenteService;
import br.com.cwi.api.validator.UsuarioJaCurtiuPostagemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CurtirPostagemService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private NowService nowService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioJaCurtiuPostagemValidator usuarioJaCurtiuPostagemValidator;

    @Transactional
    public void curtir(Long id) {

        Postagem postagem = buscarPostagemService.porId(id);
        Usuario usuario = usuarioAutenticadoService.get();

        usuarioJaCurtiuPostagemValidator.validar(postagem, usuario);

        Curtida curtida = new Curtida();
        curtida.setDataCurtida(nowService.getDateTime());

        postagem.adicionarCurtida(curtida);
        usuario.adicionarCurtida(curtida);

        curtidaRepository.save(curtida);
    }
}
