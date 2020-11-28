package br.com.cartao.transacao.domain.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoIntegracaoResponseDto {

    @NotBlank
    private final String id;
    @NotBlank
    @Email
    private final String email;

    public CartaoIntegracaoResponseDto(@NotBlank String id, @NotBlank @Email String email) {
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
