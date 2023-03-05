package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.PostagemPrivacidadeRequest;
import br.com.cwi.api.controller.response.PostagemResumidaResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.PostagemResumidaMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.validator.UsuarioDonoPostagemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlterarPostagemService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioDonoPostagemValidator usuarioDonoPostagemValidator;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemResumidaMapper postagemResumidaMapper;

    @Transactional
    public PostagemResumidaResponse editar(Long id, PostagemPrivacidadeRequest request) {

        Usuario usuarioLogado = usuarioAutenticadoService.get();
        Postagem postagem = buscarPostagemService.porId(id);

        usuarioDonoPostagemValidator.valida(usuarioLogado, postagem);

        postagem.setPrivado(request.getPrivado());

        postagemRepository.save(postagem);
        return postagemResumidaMapper.toResponse(postagem);
    }
}
