package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class UsuarioAceitandoSeuProprioConviteValidator {


    private static final String ERRO_ACEITANDO_CONVITE_PROPRIO = "Você não pode aceitar um convite que você mesmo mandou!";

    public void validar(Usuario usuarioComparar, Amizade amizade) {
        boolean isMesmoUsuarioAceitandoConvite =
                usuarioComparar.getId().equals(amizade.getUsuario().getId());

        if (isMesmoUsuarioAceitandoConvite) {
            throw new ResponseStatusException(FORBIDDEN, ERRO_ACEITANDO_CONVITE_PROPRIO);
        }
    }
}
