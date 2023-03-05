package br.com.cwi.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Getter
@Setter
public class Curtida {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDateTime dataCurtida;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

}
