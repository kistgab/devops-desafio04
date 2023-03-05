package br.com.cwi.api.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CurtidaUsuarioResponse {

    private Long id;
    private LocalDateTime dataCurtida;
    private PostagemResumidaResponse postagem;
}
