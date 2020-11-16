package br.com.zup.transacao.cartao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Cartao {
    private @NotBlank String id;
    private @NotBlank String email;

    public Cartao(@NotBlank String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }
}
