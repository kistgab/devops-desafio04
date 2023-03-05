package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Postagem;
import br.com.cwi.api.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query("SELECT DISTINCT pst " +
            "FROM Postagem pst " +
            "   JOIN pst.usuario usr " +
            "   LEFT JOIN usr.amizadesEnviadas env " +
            "   LEFT JOIN usr.amizadesRecebidas rec " +
            "WHERE (usr = :usuario " +
            "       OR (env.status = 'ACEITA' AND env.amigo = :usuario) " +
            "       OR (rec.status = 'ACEITA' AND rec.usuario = :usuario)" +
            "      ) " +
            "ORDER BY pst.dataPostagem DESC, pst.id DESC")
    Page<Postagem> findTodosPostsVisiveisOrdenadosPorMaisRecentes(Usuario usuario, Pageable pageable);

    @Query("SELECT DISTINCT pst " +
            "FROM Postagem pst " +
            "WHERE (pst.usuario.id = :usuarioParaBuscarId " +
            "       AND ((pst.privado = false " +
            "             OR (pst.privado = true " +
            "                 AND EXISTS (SELECT 1 FROM Amizade a " +
            "                              WHERE (a.usuario.id = :usuarioLogadoId AND a.amigo.id = :usuarioParaBuscarId " +
            "                                     OR a.amigo.id = :usuarioLogadoId AND a.usuario.id = :usuarioParaBuscarId) " +
            "                              AND a.status = 'ACEITA') " +
            "                )) " +
            "            OR (pst.privado = true AND pst.usuario.id = :usuarioLogadoId))) " +
            "ORDER BY pst.dataPostagem DESC, pst.id DESC")
    List<Postagem> findTodasPostagensVisiveisFromUsuarioByUsuarioLogado(Long usuarioParaBuscarId, Long usuarioLogadoId);
}
