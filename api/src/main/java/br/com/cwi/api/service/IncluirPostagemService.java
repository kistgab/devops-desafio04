package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.PostagemRequest;
import br.com.cwi.api.controller.response.PostagemResumidaResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.mapper.PostagemResumidaMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncluirPostagemService {

    @Autowired
    private PostagemResumidaMapper postagemResumidaMapper;

    @Autowired
    private NowService nowService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;

    @Transactional
    public PostagemResumidaResponse incluir(PostagemRequest request) {

        Postagem postagem = postagemResumidaMapper.toEntity(request);

        postagem.setDataPostagem(nowService.getDateTime());
        postagem.setUsuario(usuarioAutenticadoService.get());

        postagemRepository.save(postagem);

        return postagemResumidaMapper.toResponse(postagem);
    }
}
