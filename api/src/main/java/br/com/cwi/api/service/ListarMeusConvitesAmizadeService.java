package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmizadeResumidaResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.mapper.AmizadeResumidaMapper;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.cwi.api.domain.StatusAmizade.PENDENTE;
import static java.util.stream.Collectors.toList;

@Service
public class ListarMeusConvitesAmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private AmizadeResumidaMapper amizadeResumidaMapper;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<AmizadeResumidaResponse> listar() {
        Long usuarioId = usuarioAutenticadoService.getId();

        List<Amizade> convites = amizadeRepository.findByAmigoIdAndStatusEquals(usuarioId, PENDENTE);

        return convites.stream()
                .map(amizadeResumidaMapper::toResponse)
                .collect(toList());
    }
}
