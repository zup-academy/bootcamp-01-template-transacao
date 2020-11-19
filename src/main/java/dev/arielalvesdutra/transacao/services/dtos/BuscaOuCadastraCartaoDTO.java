package dev.arielalvesdutra.transacao.services.dtos;

import dev.arielalvesdutra.transacao.entities.Cartao;
import dev.arielalvesdutra.transacao.http_clients.dtos.ResultadoCartaoDTO;

public class BuscaOuCadastraCartaoDTO {

    private String id;
    private String legadoId;
    private String email;

    public BuscaOuCadastraCartaoDTO() {
    }

    public BuscaOuCadastraCartaoDTO(ResultadoCartaoDTO resultadoDTO, String email) {
        setEmail(email);
        setId(resultadoDTO.getId());
        setLegadoId(resultadoDTO.getLegadoId());
    }

    public String getId() {
        return id;
    }

    public BuscaOuCadastraCartaoDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getLegadoId() {
        return legadoId;
    }

    public BuscaOuCadastraCartaoDTO setLegadoId(String legadoId) {
        this.legadoId = legadoId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BuscaOuCadastraCartaoDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "CadastrarOuAtualizaCartaoDTO{" +
                "id='" + id + '\'' +
                ", legadoId='" + legadoId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Cartao paraEntidade() {
        return new Cartao()
                .setId(id)
                .setLegadoId(legadoId)
                .setEmail(email);
    }

    public CadastrarCartaoDTO paraCadastrarDTO() {
        return new CadastrarCartaoDTO()
                .setEmail(email)
                .setId(id)
                .setLegadoId(legadoId);
    }
}
