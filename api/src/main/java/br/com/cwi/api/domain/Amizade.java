package br.com.cwi.api.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Amizade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDate dataAmizade;

    @Enumerated(STRING)
    private StatusAmizade status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_amigo")
    private Usuario amigo;
}
