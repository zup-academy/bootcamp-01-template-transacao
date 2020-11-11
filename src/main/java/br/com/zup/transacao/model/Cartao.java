package br.com.zup.transacao.model;

import br.com.zup.transacao.dto.response.CartaoResponse;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Embeddable
public class Cartao {

    @NotNull
    private UUID cartaoID;

    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotNull UUID cartaoID, @NotBlank String email) {
        this.cartaoID = cartaoID;
        this.email = email;
    }

    public CartaoResponse toResponse(){
        return new CartaoResponse(this.cartaoID, this.email);
    }
}
