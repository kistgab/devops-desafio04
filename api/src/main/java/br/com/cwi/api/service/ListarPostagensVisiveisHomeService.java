package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.PostagemDetalhadaResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.PostagemDetalhadaMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ListarPostagensVisiveisHomeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private PostagemDetalhadaMapper postagemDetalhadaMapper;

    public Page<PostagemDetalhadaResponse> listar(Pageable pageable) {
        Usuario usuarioLogado = usuarioAutenticadoService.get();
        return postagemRepository
                .findTodosPostsVisiveisOrdenadosPorMaisRecentes(usuarioLogado, pageable)
                .map(postagemDetalhadaMapper::toResponse);
    }
}
