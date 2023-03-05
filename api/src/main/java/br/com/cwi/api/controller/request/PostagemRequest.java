package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemRequest {

    @NotBlank
    private String conteudo;

    @NotNull
    private Boolean privado;
}
