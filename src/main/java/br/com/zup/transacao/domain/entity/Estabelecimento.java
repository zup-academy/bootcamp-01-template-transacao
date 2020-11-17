package br.com.zup.transacao.domain.entity;

import br.com.zup.transacao.api.dto.ResponseEstabelecimentoDto;

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

    public ResponseEstabelecimentoDto toDto(){
        return new ResponseEstabelecimentoDto(this.nome, this.cidade, this.endereco);
    }
}
