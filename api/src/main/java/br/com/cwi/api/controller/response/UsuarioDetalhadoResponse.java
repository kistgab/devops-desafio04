package br.com.cwi.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class UsuarioDetalhadoResponse {

    private Long id;
    private String nome;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String imagemUrl;
    private boolean ativo;

    private List<PermissaoResumidaResponse> permissoes;
    private List<AmizadeResumidaResponse> amizades;
    private List<CurtidaUsuarioResponse> curtidas;
    private List<PostagemResumidaResponse> postagens;
}
