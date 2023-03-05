package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarComentarioService {

    private static final String ERRO_COMENTARIO_INEXISTENTE = "Não existe um comentário com este Id";

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario porId(Long comentarioId) {
        return comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, ERRO_COMENTARIO_INEXISTENTE));
    }
}
