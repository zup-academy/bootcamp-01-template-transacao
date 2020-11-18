package br.com.zup.transacao.listener;

import br.com.zup.transacao.model.Estabelecimento;

public class EstabelecimentoListener {

    private String nome;

    private String cidade;

    private String endereco;

    @Deprecated
    public EstabelecimentoListener() {
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

    public Estabelecimento toModel(){
        return new Estabelecimento(nome, cidade, endereco);
    }
}
