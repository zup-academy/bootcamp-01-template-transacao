package br.com.zup.bootcamp.transacao.response.listener;

import br.com.zup.bootcamp.transacao.model.Estabelecimento;

public class EstabelecimentoListenerResponse {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoListenerResponse(){
    }

    public EstabelecimentoListenerResponse(String nome, String cidade, String endereco) {
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

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "EstabelecimentoResponse{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
