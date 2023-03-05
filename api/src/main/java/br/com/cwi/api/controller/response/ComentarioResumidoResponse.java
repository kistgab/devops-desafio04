package br.com.cwi.api.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComentarioResumidoResponse {

    private Long id;
    private LocalDateTime dataCriacao;
    private String conteudo;
    private UsuarioResumidoResponse usuario;
}
