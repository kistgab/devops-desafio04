package br.com.cwi.api.controller.response;

import br.com.cwi.api.domain.StatusAmizade;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmizadeResumidaResponse {

    private Long id;
    private UsuarioResumidoResponse usuario;
    private StatusAmizade status;
}
