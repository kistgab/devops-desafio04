package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Curtida;
import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    Optional<Curtida> findByPostagemAndUsuario(Postagem postagem, Usuario usuario);
}
