package dev.arielalvesdutra.transacao.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "cartao")
public class Cartao {

    /**
     * ID cadastrado no Serviço de Propostas.
     */
    @Id
    private String id;
    /**
     * ID cadastrado no Serviço de Cartões.
     */
    @NotBlank(message = "ID do legado é obrigatório!")
    private String legadoId;
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido!")
    private String email;
    @OneToMany(mappedBy = "cartao", orphanRemoval = true, cascade = ALL)
    private Set<Transacao> transacoes = new HashSet<>();

    public Cartao() {
    }

    public String getId() {
        return id;
    }

    public Cartao setId(String id) {
        this.id = id;
        return this;
    }

    public String getLegadoId() {
        return legadoId;
    }

    public Cartao setLegadoId(String legadoId) {
        this.legadoId = legadoId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cartao setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public Cartao setTransacoes(Set<Transacao> transacoes) {
        this.transacoes = transacoes;
        return this;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", legadoId='" + legadoId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
