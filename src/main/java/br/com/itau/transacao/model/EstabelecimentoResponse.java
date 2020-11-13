package br.com.itau.transacao.model;

public class EstabelecimentoResponse {

    private final String nome;
    private final String cidade;
    private final String endereco;

    public EstabelecimentoResponse(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
