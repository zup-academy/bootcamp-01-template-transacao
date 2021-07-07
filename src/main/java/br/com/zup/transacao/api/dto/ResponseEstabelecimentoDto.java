package br.com.zup.transacao.api.dto;

public class ResponseEstabelecimentoDto {
    private String nome;
    private final String cidade;
    private final String endereco;

    public ResponseEstabelecimentoDto(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

}
