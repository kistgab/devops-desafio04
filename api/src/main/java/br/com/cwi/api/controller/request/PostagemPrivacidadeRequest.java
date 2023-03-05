package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemPrivacidadeRequest {

    @NotNull
    private Boolean privado;
}
