package dev.arielalvesdutra.transacao.services.dtos;

import dev.arielalvesdutra.transacao.entities.Cartao;

public class CadastrarCartaoDTO {

    private String id;
    private String legadoId;
    private String email;

    public CadastrarCartaoDTO() {
    }

    public String getId() {
        return id;
    }

    public CadastrarCartaoDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getLegadoId() {
        return legadoId;
    }

    public CadastrarCartaoDTO setLegadoId(String legadoId) {
        this.legadoId = legadoId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastrarCartaoDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Cartao paraEntidade() {
        return new Cartao()
                .setEmail(email)
                .setLegadoId(legadoId)
                .setId(id);
    }
}
