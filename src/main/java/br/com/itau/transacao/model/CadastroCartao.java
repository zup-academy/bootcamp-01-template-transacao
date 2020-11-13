package br.com.itau.transacao.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastroCartao {

    @NotBlank
    private final String id;
    @NotBlank
    @Email
    private final String email;

    public CadastroCartao(@NotBlank String id, @NotBlank @Email String email) {
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
