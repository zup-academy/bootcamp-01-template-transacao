package br.com.itau.transacao.model;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoListener {

    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String endereco;

    @Deprecated
    public EstabelecimentoListener() {
    }

    public EstabelecimentoListener(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
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
}
