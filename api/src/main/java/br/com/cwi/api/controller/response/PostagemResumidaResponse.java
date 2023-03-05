package br.com.cwi.api.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostagemResumidaResponse {

    private Long id;
    private String conteudo;
    private LocalDateTime dataPostagem;
    private Boolean privado;
}
