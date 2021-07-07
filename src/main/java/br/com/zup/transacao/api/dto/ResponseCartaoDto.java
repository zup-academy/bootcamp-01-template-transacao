package br.com.zup.transacao.api.dto;

import java.util.UUID;

public class ResponseCartaoDto {
    private UUID idCartao;
    private String email;

    public ResponseCartaoDto(UUID idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public UUID getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }
}
