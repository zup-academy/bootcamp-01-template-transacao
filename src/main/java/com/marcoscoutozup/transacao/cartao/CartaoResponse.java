package com.marcoscoutozup.transacao.cartao;

import java.util.UUID;

public class CartaoResponse {

    private UUID idCartao;
    private String email;

    public CartaoResponse(UUID idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public UUID getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }
}
