package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.PostagemRequest;
import br.com.cwi.api.controller.response.PostagemResumidaResponse;
import br.com.cwi.api.domain.Postagem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostagemResumidaMapper {

    Postagem toEntity(PostagemRequest request);

    PostagemResumidaResponse toResponse(Postagem postagem);
}
