package br.com.transacao.entidades;
import br.com.transacao.dtos.TransacaoDto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Cartao {

    @Id
    private String id;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "cartao")
    private Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public Cartao(){}

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Set<TransacaoDto> retornarTransacoes(){

        var transacoes = this.transacoes;

        Set<TransacaoDto> transacoesDtos = new HashSet<>();

        transacoes.forEach(transacao -> transacoesDtos.add(new TransacaoDto(transacao)));

        return transacoesDtos;

    }

    public String getId() {
        return id;
    }

    public void setId(String identification) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
