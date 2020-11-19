package dev.arielalvesdutra.transacao.controllers.dtos;

import dev.arielalvesdutra.transacao.entities.embeddables.Estabelecimento;

public class EstabelecimentoResponseDTO {

    private String cidade;
    private String nome;
    private String endereco;

    public EstabelecimentoResponseDTO() { }

    public EstabelecimentoResponseDTO(Estabelecimento estabelecimento) {
        setCidade(estabelecimento.getCidade());
        setEndereco(estabelecimento.getEndereco());
        setNome(estabelecimento.getNome());
    }

    public String getCidade() {
        return cidade;
    }

    public EstabelecimentoResponseDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public EstabelecimentoResponseDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public EstabelecimentoResponseDTO setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }
}
