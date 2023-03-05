package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarPostagemService {

    private static final String ERRO_POSTAGEM_INEXISTENTE = "Não existe uma postagem com este id!";

    @Autowired
    private PostagemRepository postagemRepository;


    public Postagem porId(Long id) {
        return postagemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, ERRO_POSTAGEM_INEXISTENTE));
    }
}
