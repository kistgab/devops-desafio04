package br.com.cwi.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String imagemUrl;
    private boolean ativo;
}
