package br.com.zup.transacao.request;

import br.com.zup.transacao.model.Cartao;

import java.util.UUID;

public class CartaoRequest {

    private UUID id;
    private String email;

    @Deprecated
    public CartaoRequest(){}

    public CartaoRequest(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toCartao(){
        return new Cartao(this.id, this.email);
    }

}
