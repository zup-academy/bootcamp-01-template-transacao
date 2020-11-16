package br.com.zup.bootcamp.transacao.response;

import br.com.zup.bootcamp.transacao.model.Cartao;

public class CartaoResponse {

    private String id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
