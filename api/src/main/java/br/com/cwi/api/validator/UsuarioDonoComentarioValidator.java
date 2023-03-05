package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Comentario;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class UsuarioDonoComentarioValidator {


    private static final String ERRO_COMENTARIO_NAO_PERTENCE_AO_USUARIO = "Este comentário não pertence a você!";

    public void validar(Usuario usuario, Comentario comentario) {
        if (!comentario.getUsuario().getId().equals(usuario.getId())) {
            throw new ResponseStatusException(FORBIDDEN, ERRO_COMENTARIO_NAO_PERTENCE_AO_USUARIO);
        }
    }
}
