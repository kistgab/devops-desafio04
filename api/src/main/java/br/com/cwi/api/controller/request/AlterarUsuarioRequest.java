package br.com.cwi.api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarUsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String apelido;

    @URL
    private String imagemUrl;
}
