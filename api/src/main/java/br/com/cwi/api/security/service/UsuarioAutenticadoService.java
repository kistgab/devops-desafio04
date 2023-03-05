package br.com.cwi.api.security.service;

import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.UsuarioMapper;
import br.com.cwi.api.repository.UsuarioRepository;
import br.com.cwi.api.security.config.UsuarioSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UsuarioAutenticadoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public Long getId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UsuarioSecurity) {
            return ((UsuarioSecurity) authentication.getPrincipal()).getId();
        }

        return null;
    }

    public Usuario get() {
        Long id = getId();

        if (isNull(id)) {
            return null;
        }

        return usuarioRepository.findById(getId()).orElse(null);
    }

    public UsuarioResponse getResponse() {
        Usuario entity = get();
        return nonNull(entity) ? usuarioMapper.toResponse(entity) : new UsuarioResponse();
    }
}
