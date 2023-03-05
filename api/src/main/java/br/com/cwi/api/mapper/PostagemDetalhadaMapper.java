package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.PostagemDetalhadaResponse;
import br.com.cwi.api.domain.Postagem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostagemDetalhadaMapper {

    PostagemDetalhadaResponse toResponse(Postagem postagem);
}
