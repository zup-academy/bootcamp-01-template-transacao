package com.transacao.criacaotransacao;

import javax.validation.constraints.NotNull;

public class EstabelecimentoResponseListener {

    @NotNull
    private String nome;

    @NotNull
    private String cidade;

    @NotNull
    private String endereco;

    public Estabelecimento toEstabelecimento(){
        return new Estabelecimento(nome, cidade, endereco);
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

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
