package br.com.cwi.api.service;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.Usuario;
import br.com.cwi.api.repository.AmizadeRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.core.BuscarAmizadeService;
import br.com.cwi.api.validator.AmizadeNecessitaStatusValidator;
import br.com.cwi.api.validator.UsuarioAceitandoSeuProprioConviteValidator;
import br.com.cwi.api.validator.UsuarioLogadoPertenceAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.domain.StatusAmizade.ACEITA;
import static br.com.cwi.api.domain.StatusAmizade.PENDENTE;

@Service
public class AceitarConviteAmizadeService {

    @Autowired
    private BuscarAmizadeService buscarAmizadeService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioLogadoPertenceAmizadeValidator usuarioLogadoPertenceAmizadeValidator;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private AmizadeNecessitaStatusValidator amizadeNecessitaStatusValidator;

    @Autowired
    private UsuarioAceitandoSeuProprioConviteValidator usuarioAceitandoSeuProprioConviteValidator;

    public void aceitar(Long id) {

        Amizade amizade = buscarAmizadeService.porId(id);
        amizadeNecessitaStatusValidator.validar(amizade, PENDENTE);

        Usuario usuarioLogado = usuarioAutenticadoService.get();

        usuarioLogadoPertenceAmizadeValidator.validar(usuarioLogado, amizade);
        usuarioAceitandoSeuProprioConviteValidator.validar(usuarioLogado, amizade);

        amizade.setStatus(ACEITA);

        amizadeRepository.save(amizade);
    }
}
