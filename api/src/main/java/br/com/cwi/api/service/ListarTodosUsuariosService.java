package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.mapper.UsuarioMapper;
import br.com.cwi.api.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarTodosUsuariosService {


    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioResponse> listar(String filtro) {
        Long usuarioLogadoId = usuarioAutenticadoService.getId();

        return usuarioRepository
                .findPorIdOuEmailIgualAoFiltroEDiferenteUsuarioLogado(usuarioLogadoId, filtro).stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }
}
