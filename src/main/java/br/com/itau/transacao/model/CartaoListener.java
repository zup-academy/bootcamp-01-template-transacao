package br.com.itau.transacao.model;

import javax.validation.constraints.NotBlank;

public class CartaoListener {

    @NotBlank
    private String id;
    @NotBlank
    private String email;

    @Deprecated
    public CartaoListener() {
    }

    public CartaoListener(@NotBlank String id, @NotBlank String email) {
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
