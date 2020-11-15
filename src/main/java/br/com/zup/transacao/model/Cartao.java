package br.com.zup.transacao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class Cartao {

    @Column(name = "numero_cartao")
    private UUID id;
    private String email;

    @Deprecated
    public Cartao(){}

    public Cartao(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
