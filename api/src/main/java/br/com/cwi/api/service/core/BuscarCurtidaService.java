package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Curtida;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.CurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarCurtidaService {

    private static final String ERRO_CURTIDA_INEXISTENTE = "Você nunca curtiu esta postagem!";

    @Autowired
    private CurtidaRepository curtidaRepository;

    public Curtida get(Postagem postagem, Usuario usuario) {
        return curtidaRepository.findByPostagemAndUsuario(postagem, usuario)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, ERRO_CURTIDA_INEXISTENTE));
    }
}
