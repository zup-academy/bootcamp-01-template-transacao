package com.marcoscoutozup.transacao.cartao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Embeddable
public class Cartao {

    @NotNull
    private UUID idCartao;

    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(UUID idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }
            //1
    public CartaoResponse toResponse(){
        return new CartaoResponse(this.idCartao, this.email);
    }

    public boolean verificarParidadeDeEmail(String email) {
        return this.email.equals(email);
    }
}
