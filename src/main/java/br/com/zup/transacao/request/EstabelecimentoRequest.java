package br.com.zup.transacao.request;

import br.com.zup.transacao.model.Estabelecimento;

public class EstabelecimentoRequest {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoRequest(){}

    public EstabelecimentoRequest(String nome, String cidade, String endereco) {
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

    public Estabelecimento toEstabelecimento(){
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }

}
