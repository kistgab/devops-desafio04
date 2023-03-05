package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AdicionarComentarioRequest;
import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.ComentarioMapper;
import br.com.cwi.api.repository.ComentarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdicionarComentarioService {

    @Autowired
    private ComentarioMapper comentarioMapper;

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private NowService nowService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Transactional
    public void adicionar(Long id, AdicionarComentarioRequest request) {

        Postagem postagem = buscarPostagemService.porId(id);
        Usuario usuario = usuarioAutenticadoService.get();

        Comentario comentario = comentarioMapper.toEntity(request);

        comentario.setDataCriacao(nowService.getDateTime());
        comentario.setUsuario(usuario);

        postagem.adicionarComentario(comentario);

        comentarioRepository.save(comentario);
    }
}
