package br.com.zup.transacao.listener;

import br.com.zup.transacao.model.Estabelecimento;

public class EstabelecimentoListener {

    private String nome;

    private String cidade;

    private String endereco;

    public Estabelecimento toModel(){
        return new Estabelecimento(nome, cidade, endereco);
    }
}
