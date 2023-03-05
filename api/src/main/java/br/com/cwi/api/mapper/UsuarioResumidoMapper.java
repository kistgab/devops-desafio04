package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.UsuarioResumidoResponse;
import br.com.cwi.api.domain.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioResumidoMapper {

    UsuarioResumidoResponse toResponse(Usuario usuario);
}
