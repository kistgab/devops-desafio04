package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.UsuarioRequest;
import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.mapper.UsuarioMapper;
import br.com.cwi.api.repository.UsuarioRepository;
import br.com.cwi.api.security.domain.Permissao;
import br.com.cwi.api.service.core.NowService;
import br.com.cwi.api.service.core.ValidaEmailUnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static br.com.cwi.api.security.domain.Funcao.USUARIO;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private ValidaEmailUnicoService validaEmailUnicoService;

    @Autowired
    private NowService nowService;

    @Transactional
    public UsuarioResponse incluir(UsuarioRequest request) {
        validaEmailUnicoService.validar(request.getEmail());

        Usuario usuario = usuarioMapper.toEntity(request);
        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setDataCadastro(nowService.getDate());
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }
}
