package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Permissao;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String senha;
    private String imagemUrl;
    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    private List<Amizade> amizadesEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "amigo", cascade = ALL)
    private List<Amizade> amizadesRecebidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = ALL)
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.getPermissoes().add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarCurtida(Curtida curtida) {
        this.getCurtidas().add(curtida);
        curtida.setUsuario(this);
    }

    public void removerCurtida(Curtida curtida) {
        this.getCurtidas().remove(curtida);
    }

    public void enviarConviteAmizade(Amizade amizade) {
        this.getAmizadesEnviadas().add(amizade);
        amizade.setUsuario(this);
    }

    public void receberConviteAmizade(Amizade amizade) {
        this.getAmizadesRecebidas().add(amizade);
        amizade.setAmigo(this);
    }

    public void cancelarConviteAmizade(Amizade amizade) {
        this.getAmizadesEnviadas().remove(amizade);
    }

    public void excluirConviteAmizade(Amizade amizade) {
        this.getAmizadesRecebidas().remove(amizade);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
