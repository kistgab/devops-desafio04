package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.AdicionarComentarioRequest;
import br.com.cwi.api.domain.Comentario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    Comentario toEntity(AdicionarComentarioRequest request);
}
