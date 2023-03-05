package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class UsuarioDonoPostagemValidator {

    private static final String ERRO_NAO_E_DONO_POSTAGEM = "Você não pode editar um post que nao lhe pertence!";

    public void valida(Usuario usuarioLogado, Postagem postagem) {
        if (!postagem.getUsuario().getId().equals(usuarioLogado.getId())) {
            throw new ResponseStatusException(FORBIDDEN, ERRO_NAO_E_DONO_POSTAGEM);
        }
    }
}
