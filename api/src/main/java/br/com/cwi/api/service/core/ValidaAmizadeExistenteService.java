package br.com.cwi.api.service.core;

import br.com.cwi.api.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaAmizadeExistenteService {

    private static final String ERRO_USUARIOS_JA_SAO_AMIGOS = "Os usuários já possuem uma amizade, caso não encontre, verifique se ela não esta pendente!";
    @Autowired
    private AmizadeRepository amizadeRepository;

    public void validar(Long id1, Long id2) {
        if (amizadeRepository.existsByIds(id1, id2)) {
            throw new ResponseStatusException(BAD_REQUEST, ERRO_USUARIOS_JA_SAO_AMIGOS);
        }
    }
}
