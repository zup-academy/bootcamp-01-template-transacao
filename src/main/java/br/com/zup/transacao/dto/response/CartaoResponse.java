package br.com.zup.transacao.dto.response;

import br.com.zup.transacao.model.Cartao;

import java.util.UUID;

public class CartaoResponse {

    private String cartaoID;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.cartaoID = cartao.getId();
        this.email = cartao.getEmail();
    }
}
