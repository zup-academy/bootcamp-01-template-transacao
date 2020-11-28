package br.com.cartao.transacao.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VencimentoIntegracaoResponseDto {

    private String id;
    private Integer dia;
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss", shape = JsonFormat.Shape.STRING)
    private String dataDeCriacao;

    @Deprecated
    public VencimentoIntegracaoResponseDto() {
    }

    public VencimentoIntegracaoResponseDto(String id, Integer dia, String dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Override
    public String toString() {
        return "VencimentoResponseDto{" +
                "id='" + id + '\'' +
                ", dia=" + dia +
                ", dataDeCriacao=" + dataDeCriacao +
                '}';
    }
}
