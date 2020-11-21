package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NamedQuery(name = "findTransacoesPorCartao", query = "SELECT t FROM Transacao t WHERE t.cartao.idCartao = :idCartao ORDER BY efetivadaEm DESC")
public class Transacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    private String idTransacao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull
    @Embedded
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String idTransacao, @NotNull @Positive BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toResponse(){
        return new TransacaoResponse(this.valor, this.estabelecimento.toResponse(), this.cartao.toResponse(), this.efetivadaEm);
    }
    public static List<TransacaoResponse> toListResponse(List<Transacao> transacaos){
        Assert.notNull(transacaos, "A lista de transações não pode ser nula");
        return transacaos.stream().map(Transacao::toResponse).collect(Collectors.toList());
    }


}
