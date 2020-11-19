package com.transacao.criacaotransacao;

public class CartaoResponseListener {

    private String id;

    private String email;

    public Cartao toCartao() {
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
