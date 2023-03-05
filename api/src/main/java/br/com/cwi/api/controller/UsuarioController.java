package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AlterarUsuarioRequest;
import br.com.cwi.api.controller.request.UsuarioRequest;
import br.com.cwi.api.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.api.controller.response.UsuarioResponse;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.AlterarUsuarioService;
import br.com.cwi.api.service.DetalharUsuarioService;
import br.com.cwi.api.service.IncluirUsuarioService;
import br.com.cwi.api.service.ListarTodosUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private AlterarUsuarioService alterarUsuarioService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private ListarTodosUsuariosService listarTodosUsuariosService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping
    public UsuarioResponse alterar(@Valid @RequestBody AlterarUsuarioRequest request) {
        return alterarUsuarioService.alterar(request);
    }

    @GetMapping("/{id}")
    public UsuarioDetalhadoResponse detalhar(@PathVariable Long id) {
        return detalharUsuarioService.detalhar(id);
    }

    @GetMapping("/me")
    public UsuarioResponse detalharInformacoesBasicasUserLogado() {
        return usuarioAutenticadoService.getResponse();
    }

    @GetMapping
    public List<UsuarioResponse> listarTodosUsuarios(
            @RequestParam(defaultValue = "") String filtro
    ) {
        return listarTodosUsuariosService.listar(filtro);
    }

}
