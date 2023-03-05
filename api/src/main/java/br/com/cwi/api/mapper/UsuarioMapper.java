package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.UsuarioRequest;
import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.domain.Usuario;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequest request);

    UsuarioResponse toResponse(Usuario entity);
}
