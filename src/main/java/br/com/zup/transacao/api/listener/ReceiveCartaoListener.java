package br.com.zup.transacao.api.listener;

import br.com.zup.transacao.domain.entity.Cartao;

import java.util.UUID;

public class ReceiveCartaoListener {

    private UUID id;
    private String email;

    public Cartao toCartao(){
        return new Cartao(id, email);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
