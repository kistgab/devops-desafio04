package br.com.cwi.api.validator;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.StatusAmizade;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class AmizadeNecessitaStatusValidator {

    public void validar(Amizade amizade, StatusAmizade status) {
        String ERRO_SITUACAO_ERRADA =
                "A situação precisa ser " + status.toString() + " para conseguir fazer esta ação!";

        if (!amizade.getStatus().equals(status)) {

            throw new ResponseStatusException(BAD_REQUEST, ERRO_SITUACAO_ERRADA);
        }
    }
}
