package io.github.evertocnsouza.listener;

import io.github.evertocnsouza.entity.Estabelecimento;

public class EstabelecimentoListener {

    private String nome;
    private String cidade;
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

    public void setEndereco(String bairro) {
        this.endereco = bairro;
    }

}