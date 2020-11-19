package dev.arielalvesdutra.transacao.http_clients.dtos;

public class ResultadoCartaoDTO {

    private String id;
    private String legadoId;

    public ResultadoCartaoDTO() {
    }

    public String getId() {
        return id;
    }

    public ResultadoCartaoDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getLegadoId() {
        return legadoId;
    }

    public ResultadoCartaoDTO setLegadoId(String legadoId) {
        this.legadoId = legadoId;
        return this;
    }

    @Override
    public String toString() {
        return "ResultadoCartaoDTO{" +
                "id='" + id + '\'' +
                ", legadoId='" + legadoId + '\'' +
                '}';
    }
}
