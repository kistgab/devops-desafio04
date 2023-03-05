package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.CurtidaUsuarioResponse;
import br.com.cwi.api.controller.response.PermissaoResumidaResponse;
import br.com.cwi.api.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.api.domain.Curtida;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.security.domain.Permissao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioDetalhadoMapper {

    UsuarioDetalhadoResponse toResponse(Usuario usuario);

    @Mapping(target = "id", source = "value.id")
    @Mapping(target = "funcao", source = "value.funcao")
    PermissaoResumidaResponse map(Permissao value);

    CurtidaUsuarioResponse map(Curtida value);
}
