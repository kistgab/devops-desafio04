package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.StatusAmizade;
import br.com.cwi.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Amizade> findAllByAmizadesRecebidasStatusEquals(StatusAmizade status);

    @Query("SELECT u FROM Usuario u " +
            "WHERE (u.id != :id) " +
            "AND (LOWER(u.nome) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :filtro, '%'))) ")
    List<Usuario> findPorIdOuEmailIgualAoFiltroEDiferenteUsuarioLogado(Long id, String filtro);
}
