package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class UsuarioDiferenteAdicionarAmigoValidator {


    private static final String ERRO_ADICIONAR_A_SI_MESMO = "Você não pode adiconar a si mesmo!";

    public void validar(Usuario usuario, Usuario amigo) {
        if (usuario.getId().equals(amigo.getId())) {
            throw new ResponseStatusException(BAD_REQUEST, ERRO_ADICIONAR_A_SI_MESMO);
        }
    }
}
