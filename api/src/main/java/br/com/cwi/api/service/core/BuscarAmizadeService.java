package br.com.cwi.api.service.core;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarAmizadeService {

    private static final String AMIZADE_NAO_ENCONTRADA = "Não foi encontrada nenhuma amizade com este id!";
    @Autowired
    private AmizadeRepository amizadeRepository;


    public Amizade porId(Long id) {
        return amizadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, AMIZADE_NAO_ENCONTRADA));
    }
}
