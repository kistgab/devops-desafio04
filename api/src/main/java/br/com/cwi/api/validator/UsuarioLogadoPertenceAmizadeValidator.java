package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class UsuarioLogadoPertenceAmizadeValidator {


    private static final String ERRO_USUARIO_LOGADO_NAO_PRESENTE = "Você não pertence a esta amizade, e portanto não pode executar ações nela!";

    public void validar(Usuario usuarioLogado, Amizade amizade) {
        Usuario usuario = amizade.getUsuario();
        Usuario amigo = amizade.getAmigo();

        boolean isUsuarioLogadoAmigo = usuarioLogado.getId().equals(amigo.getId());
        boolean isUsuarioLogadoUsuario = usuarioLogado.getId().equals(usuario.getId());

        if (!isUsuarioLogadoUsuario && !isUsuarioLogadoAmigo) {
            throw new ResponseStatusException(FORBIDDEN, ERRO_USUARIO_LOGADO_NAO_PRESENTE);
        }
    }
}
