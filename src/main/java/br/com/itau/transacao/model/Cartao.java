package br.com.itau.transacao.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotNull
    private UUID numeroCartao;
    @NotBlank
    private String email;
    @OneToOne
    @JoinColumn(name = "id")
    private Compra compra;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank UUID numeroCartao, @NotBlank String email) {
        this.numeroCartao = numeroCartao;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(UUID numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
