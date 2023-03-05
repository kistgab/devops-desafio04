package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.api.repository.PostagemRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalharUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioDetalhadoMapper usuarioDetalhadoMapper;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostagemRepository postagemRepository;

    public UsuarioDetalhadoResponse detalhar(Long id) {

        Usuario usuario = buscarUsuarioService.porId(id);

        Usuario usuarioLogado = usuarioAutenticadoService.get();

        List<Postagem> postagensFiltradas =
                postagemRepository.findTodasPostagensVisiveisFromUsuarioByUsuarioLogado(usuario.getId(), usuarioLogado.getId());
        usuario.setPostagens(postagensFiltradas);

        return usuarioDetalhadoMapper.toResponse(usuario);
    }
}
