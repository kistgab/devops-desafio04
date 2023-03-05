package br.com.cwi.api.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResumidoResponse {

    private Long id;
    private String nome;
    private String imagemUrl;
}
