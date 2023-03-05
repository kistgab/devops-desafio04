package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.AmizadeResumidaResponse;
import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.AmizadeResumidaMapper;
import br.com.cwi.api.mapper.UsuarioResumidoMapper;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarMinhasAmizadesService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private AmizadeResumidaMapper amizadeResumidaMapper;

    @Autowired
    private UsuarioResumidoMapper usuarioResumidoMapper;

    public List<AmizadeResumidaResponse> listar(String filtro) {
        Long usuarioLogadoId = usuarioAutenticadoService.getId();

        return amizadeRepository.findAmizadesByNomeOrEmailAndUsuario(usuarioLogadoId, filtro).stream()
                .map((Amizade amizade) -> {
                    Usuario usuario = amizade.getUsuario().getId().equals(usuarioLogadoId)
                            ? amizade.getAmigo()
                            : amizade.getUsuario();

                    return AmizadeResumidaResponse.builder()
                            .id(amizade.getId())
                            .usuario(usuarioResumidoMapper.toResponse(usuario))
                            .status(amizade.getStatus())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
