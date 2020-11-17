package br.com.zup.transacao.domain.entity;

import br.com.zup.transacao.api.dto.ResponseCartaoDto;

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

    public ResponseCartaoDto toDto(){
        return new ResponseCartaoDto(this.idCartao, this.email);
    }
}
