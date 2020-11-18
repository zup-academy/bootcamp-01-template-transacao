package br.com.zup.transacao.cartao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Cartao {
    private @NotBlank String idCartao;
    private @NotBlank String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank String idCartao, @NotBlank String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public CartaoResponse toResponse() {
        return new CartaoResponse(idCartao, email);
    }
}
