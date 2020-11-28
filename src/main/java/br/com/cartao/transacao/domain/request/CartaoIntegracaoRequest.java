package br.com.cartao.transacao.domain.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoIntegracaoRequest {

    @NotBlank
    private final String id;
    @NotBlank
    @Email
    private final String email;

    public CartaoIntegracaoRequest(@NotBlank String id, @NotBlank @Email String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
