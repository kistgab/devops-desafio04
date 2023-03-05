package br.com.cwi.api.controller.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AdicionarComentarioRequest {

    @NotBlank
    private String conteudo;
}
