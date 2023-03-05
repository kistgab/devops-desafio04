package br.com.cwi.api.controller;

import br.com.cwi.api.controller.response.AmizadeResumidaResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private ListarMeusConvitesAmizadeService listarMeusConvitesAmizadeService;

    @Autowired
    private AdicionarAmigoService adicionarAmigoService;

    @Autowired
    private RecusarConviteAmizadeService recusarConviteAmizadeService;

    @Autowired
    private AceitarConviteAmizadeService aceitarConviteAmizadeService;

    @Autowired
    private ListarMinhasAmizadesService listarMinhasAmizadesService;

    @GetMapping("/me")
    public List<AmizadeResumidaResponse> listarMinhasAmizades(
            @RequestParam(defaultValue = "") String filtro
    ) {
        return listarMinhasAmizadesService.listar(filtro);
    }

    @GetMapping("/me/convites")
    public List<AmizadeResumidaResponse> listarMeusConvitesDeAmizade() {
        return listarMeusConvitesAmizadeService.listar();
    }

    @PostMapping("/adicionar/{amigoId}")
    @ResponseStatus(CREATED)
    public void adicionarAmigo(@PathVariable Long amigoId) {
        adicionarAmigoService.adicionar(amigoId);
    }

    @PutMapping("/me/{id}")
    @ResponseStatus(NO_CONTENT)
    public void aceitar(@PathVariable Long id) {
        aceitarConviteAmizadeService.aceitar(id);
    }

    @DeleteMapping("/me/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarAmizade(@PathVariable Long id) {
        recusarConviteAmizadeService.recusar(id);
    }


}
