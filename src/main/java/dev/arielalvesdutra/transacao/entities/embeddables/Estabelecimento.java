package dev.arielalvesdutra.transacao.entities.embeddables;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public Estabelecimento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Estabelecimento setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }
}
