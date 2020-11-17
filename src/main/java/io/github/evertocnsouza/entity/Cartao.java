package io.github.evertocnsouza.entity;

import io.github.evertocnsouza.dto.CartaoResponse;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Embeddable
public class Cartao {

    @NotNull
    private UUID idCartao;

    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(UUID idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public CartaoResponse toResponse(){
        return new CartaoResponse(this.idCartao, this.email);
    }
}