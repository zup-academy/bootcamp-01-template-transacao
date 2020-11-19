package dev.arielalvesdutra.transacao.configs.dtos;


import dev.arielalvesdutra.transacao.entities.embeddables.Estabelecimento;

public class TransacaoMessageEstabelecimentoDTO {

    private String nome;
    private String cidade;
    private String endereco;

    public TransacaoMessageEstabelecimentoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public TransacaoMessageEstabelecimentoDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public TransacaoMessageEstabelecimentoDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public TransacaoMessageEstabelecimentoDTO setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public String toString() {
        return "TransacaoMessageEstabelecimentoDTO{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Estabelecimento paraEmbeddable() {
        return new Estabelecimento()
                .setCidade(cidade)
                .setEndereco(endereco)
                .setNome(nome);
    }
}
