package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AlterarUsuarioRequest;
import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.UsuarioMapper;
import br.com.cwi.api.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlterarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioResponse alterar(AlterarUsuarioRequest request) {
        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setApelido(request.getApelido());
        usuario.setNome(request.getNome());
        usuario.setImagemUrl(request.getImagemUrl());

        usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuario);
    }
}
