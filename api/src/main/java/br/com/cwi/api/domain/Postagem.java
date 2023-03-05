package br.com.cwi.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String conteudo;
    private LocalDateTime dataPostagem;
    private Boolean privado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "postagem", cascade = ALL)
    List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "postagem", cascade = ALL)
    List<Comentario> comentarios = new ArrayList<>();

    public void adicionarCurtida(Curtida curtida) {
        this.getCurtidas().add(curtida);
        curtida.setPostagem(this);
    }

    public void removerCurtida(Curtida curtida) {
        this.getCurtidas().remove(curtida);
    }

    public void removerComentario(Comentario comentario) {
        this.getComentarios().remove(comentario);
    }

    public void adicionarComentario(Comentario comentario) {
        this.getComentarios().add(comentario);
        comentario.setPostagem(this);
    }
}
