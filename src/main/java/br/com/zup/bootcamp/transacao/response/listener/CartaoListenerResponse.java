package br.com.zup.bootcamp.transacao.response.listener;

import br.com.zup.bootcamp.transacao.model.Cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoListenerResponse {
    @NotNull
    private String id;

    @NotBlank
    private String email;

    @Deprecated
    public CartaoListenerResponse(){
    }

    public CartaoListenerResponse(@NotNull String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
