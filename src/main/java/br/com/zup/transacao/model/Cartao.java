package br.com.zup.transacao.model;

import br.com.zup.transacao.dto.response.CartaoResponse;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    private String id;

    @NotBlank
    private String email;

    @Deprecated
    public Cartao(){
    }

    public Cartao(@NotNull String id, @NotBlank String email) {
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