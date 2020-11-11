package br.com.zup.transacao.model;

import br.com.zup.transacao.dto.response.EstabelecimentoResponse;

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

    public EstabelecimentoResponse toResponse(){
        return new EstabelecimentoResponse(this.nome, this.cidade, this.endereco);
    }

    public Estabelecimento(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }
}
