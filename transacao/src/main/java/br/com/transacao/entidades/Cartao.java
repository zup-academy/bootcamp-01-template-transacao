package br.com.transacao.entidades;

import br.com.transacao.dtos.TransacaoDto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.*;


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

    public List<TransacaoDto> retornarTransacoes(){

        var transacoesDtos = new ArrayList<TransacaoDto>();

        this.transacoes.forEach(transacao -> transacoesDtos.add(new TransacaoDto(transacao)));

        transacoesDtos.sort(Comparator.comparing(TransacaoDto::getEfetivadaEm));

        Collections.reverse(transacoesDtos);

        return transacoesDtos.subList(0,10);

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
