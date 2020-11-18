package br.com.zup.transacao.dto.response;

import br.com.zup.transacao.model.Estabelecimento;

public class EstabelecimentoResponse {

    private String nome;

    private String cidade;

    private String endereco;

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }
}
