package com.marcoscoutozup.transacao.cartao;

import java.util.UUID;

public class CartaoResponseListener {

    private UUID id;
    private String email;

            //1
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

