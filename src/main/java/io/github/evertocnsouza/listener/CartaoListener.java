package io.github.evertocnsouza.listener;

import io.github.evertocnsouza.entity.Cartao;
import java.util.UUID;

public class CartaoListener {

    private UUID id;
    private String email;

    public Cartao toCartao(){
        return new Cartao(id, email);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
