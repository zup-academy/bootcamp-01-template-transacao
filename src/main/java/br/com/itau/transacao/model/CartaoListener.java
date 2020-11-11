package br.com.itau.transacao.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CartaoListener {

    @NotNull
    private UUID id;
    @NotBlank
    private String email;

    @Deprecated
    public CartaoListener() {
    }

    public CartaoListener(@NotNull UUID id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
