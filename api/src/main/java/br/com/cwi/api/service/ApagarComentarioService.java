package br.com.cwi.api.service;

import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.ComentarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarComentarioService;
import br.com.cwi.api.service.core.BuscarPostagemService;
import br.com.cwi.api.validator.UsuarioDonoComentarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApagarComentarioService {

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private BuscarComentarioService buscarComentarioService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioDonoComentarioValidator usuarioDonoComentarioValidator;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Transactional
    public void apagar(Long postagemId, Long comentarioId) {

        Postagem postagem = buscarPostagemService.porId(postagemId);
        Comentario comentario = buscarComentarioService.porId(comentarioId);
        Usuario usuario = usuarioAutenticadoService.get();

        usuarioDonoComentarioValidator.validar(usuario, comentario);

        postagem.removerComentario(comentario);

        comentarioRepository.delete(comentario);
    }
}
