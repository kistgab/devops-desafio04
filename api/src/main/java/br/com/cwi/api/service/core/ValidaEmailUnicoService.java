package br.com.cwi.api.service.core;

import br.com.cwi.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaEmailUnicoService {

    private static final String ERRO_USUARIO_JA_CADASTRADO = "Já existe um usuário cadastrado com este e-mail!";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new ResponseStatusException(BAD_REQUEST, ERRO_USUARIO_JA_CADASTRADO);
        }
    }
}
