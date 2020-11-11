package br.com.zup.transacao.dto.response;

import java.util.UUID;

public class CartaoResponse {

    private UUID cartaoID;
    private String email;

    public CartaoResponse(UUID cartaoID, String email) {
        this.cartaoID = cartaoID;
        this.email = email;
    }
}
