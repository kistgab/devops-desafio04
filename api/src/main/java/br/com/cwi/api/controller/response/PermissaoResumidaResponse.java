package br.com.cwi.api.controller.response;

import br.com.cwi.api.security.domain.Funcao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissaoResumidaResponse {
    private Long id;
    private Funcao funcao;
}
