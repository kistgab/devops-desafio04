package br.com.cwi.api.controller.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostagemDetalhadaResponse {

    private Long id;
    private String conteudo;
    private LocalDateTime dataPostagem;
    private Boolean privado;

    private UsuarioResponse usuario;

    List<CurtidaResumidaResponse> curtidas = new ArrayList<>();
    List<ComentarioResumidoResponse> comentarios = new ArrayList<>();
}
