package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Amizade;
import br.com.cwi.api.domain.StatusAmizade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {


    List<Amizade> findByAmigoIdAndStatusEquals(Long id, StatusAmizade status);

    @Query("SELECT COUNT(a) > 0 " +
            " FROM Amizade a " +
            " WHERE (a.usuario.id = :id1 AND a.amigo.id = :id2) " +
            "       OR (a.usuario.id = :id2 AND a.amigo.id = :id1) ")
    boolean existsByIds(Long id1, Long id2);


    @Query("SELECT amz FROM Amizade amz " +
            "JOIN amz.amigo amg " +
            "JOIN amz.usuario usr " +
            "WHERE amz.status = 'ACEITA' " +
            "AND (amg.id = :usuarioId OR usr.id = :usuarioId) " +
            "AND ( " +
            "  LOWER(amg.nome) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "  OR LOWER(usr.nome) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "  OR LOWER(amg.email) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "  OR LOWER(usr.email) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            ")")
    List<Amizade> findAmizadesByNomeOrEmailAndUsuario(Long usuarioId, String filtro);

}
