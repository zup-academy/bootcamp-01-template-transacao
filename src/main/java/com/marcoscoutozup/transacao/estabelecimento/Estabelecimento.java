package com.marcoscoutozup.transacao.estabelecimento;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Estabelecimento {

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }
            //1
    public EstabelecimentoResponse toResponse(){
        return new EstabelecimentoResponse(this.nome, this.cidade, this.endereco);
    }
}
