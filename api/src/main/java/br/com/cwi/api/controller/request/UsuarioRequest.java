package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;
}
