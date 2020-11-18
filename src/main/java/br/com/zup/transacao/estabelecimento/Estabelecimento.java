package br.com.zup.transacao.estabelecimento;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Estabelecimento {
    private @NotBlank String nome;
    private @NotBlank String cidade;
    private @NotBlank String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoResponse toResponse() {
        return new EstabelecimentoResponse(nome, cidade, endereco);
    }
}
