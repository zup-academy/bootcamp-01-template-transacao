package br.com.zup.transacao.listener;

import br.com.zup.transacao.model.Cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CartaoListener {

    @NotNull
    private String id;

    @NotBlank
    private String email;


    @Deprecated
    public CartaoListener(){
    }

    public CartaoListener(@NotNull String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(){
        return new Cartao(id, email);
    }

}
