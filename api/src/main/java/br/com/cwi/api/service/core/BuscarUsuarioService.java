package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarUsuarioService {

    private final String ERRO_USUARIO_INEXISTENTE = "Usuário buscado não existe na base de dados!";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario porId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, ERRO_USUARIO_INEXISTENTE));
    }
}
