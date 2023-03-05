package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class UsuarioJaCurtiuPostagemValidator {

    private static final String ERRO_JA_CURTIU = "Você não pode curtir duas vezes a mesma postagem";

    public void validar(Postagem postagem, Usuario usuario) {
        boolean isUsuarioJaCurtiuPostagem = postagem.getCurtidas().stream()
                .anyMatch((curtida) -> curtida.getUsuario().getId().equals(usuario.getId()));

        if (isUsuarioJaCurtiuPostagem) {
            throw new ResponseStatusException(BAD_REQUEST, ERRO_JA_CURTIU);
        }
    }
}
