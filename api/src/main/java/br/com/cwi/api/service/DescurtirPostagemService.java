package br.com.cwi.api.service;

import br.com.cwi.api.domain.Curtida;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.CurtidaRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarCurtidaService;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DescurtirPostagemService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private NowService nowService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private BuscarCurtidaService buscarCurtidaService;

    @Transactional
    public void descurtir(Long id) {
        Usuario usuario = usuarioAutenticadoService.get();
        Postagem postagem = buscarPostagemService.porId(id);

        Curtida curtida = buscarCurtidaService.get(postagem, usuario);

        postagem.removerCurtida(curtida);
        usuario.removerCurtida(curtida);

        curtidaRepository.delete(curtida);
    }
}
