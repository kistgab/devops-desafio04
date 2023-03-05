package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AmizadeResumidaResponse;
import br.com.cwi.api.domain.Amizade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UsuarioResumidoMapper.class)
public interface AmizadeResumidaMapper {

    AmizadeResumidaResponse toResponse(Amizade amizade);

}
