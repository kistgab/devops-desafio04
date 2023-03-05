package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AdicionarComentarioRequest;
import br.com.cwi.api.controller.request.PostagemPrivacidadeRequest;
import br.com.cwi.api.controller.request.PostagemRequest;
import br.com.cwi.api.controller.response.PostagemDetalhadaResponse;
import br.com.cwi.api.controller.response.PostagemResumidaResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private IncluirPostagemService incluirPostagemService;

    @Autowired
    private AlterarPostagemService alterarPostagemService;

    @Autowired
    private ListarPostagensVisiveisHomeService listarPostagensVisiveisHomeService;

    @Autowired
    private CurtirPostagemService curtirPostagemService;

    @Autowired
    private DescurtirPostagemService descurtirPostagemService;

    @Autowired
    private ApagarComentarioService apagarComentarioService;

    @Autowired
    private AdicionarComentarioService adicionarComentarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public PostagemResumidaResponse incluir(@Valid @RequestBody PostagemRequest request) {
        return incluirPostagemService.incluir(request);
    }

    @PutMapping("/{id}")
    public PostagemResumidaResponse editar(@PathVariable Long id, @Valid @RequestBody PostagemPrivacidadeRequest request) {
        return alterarPostagemService.editar(id, request);
    }

    @GetMapping
    public Page<PostagemDetalhadaResponse> listar(Pageable pageable) {
        return listarPostagensVisiveisHomeService.listar(pageable);
    }

    @PostMapping("/{id}/curtidas")
    @ResponseStatus(CREATED)
    public void curtir(@PathVariable Long id) {
        curtirPostagemService.curtir(id);
    }

    @DeleteMapping("/{id}/curtidas")
    @ResponseStatus(NO_CONTENT)
    public void descurtir(@PathVariable Long id) {
        descurtirPostagemService.descurtir(id);
    }

    @PostMapping("/{id}/comentarios")
    @ResponseStatus(CREATED)
    public void comentar(@PathVariable Long id, @Valid @RequestBody AdicionarComentarioRequest request) {
        adicionarComentarioService.adicionar(id, request);
    }

    @DeleteMapping("/{id}/comentarios/{comentarioId}")
    @ResponseStatus(NO_CONTENT)
    public void apagarComentario(@PathVariable Long id, @PathVariable Long comentarioId) {
        apagarComentarioService.apagar(id, comentarioId);
    }
}
