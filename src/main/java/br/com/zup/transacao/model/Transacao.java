package br.com.zup.transacao.model;

import br.com.zup.transacao.dto.response.TransacaoResponse;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@NamedQuery(
        name = "findTransacoesPorCartao",
        query = "SELECT t FROM Transacao t WHERE t.cartao.cartaoID = :cartaoID ORDER BY efetivadaEm DESC")
public class Transacao {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotNull
    private UUID transacaoID;

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

    public Transacao(@NotNull UUID transacaoID, @NotNull @Positive BigDecimal valor, @NotNull Estabelecimento estabelecimento, @NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.transacaoID = transacaoID;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toResponse(){
        return new TransacaoResponse(this.valor, this.estabelecimento.toResponse(), this.cartao.toResponse(), this.efetivadaEm);
    }

    public static List<TransacaoResponse> toResponseList(List<Transacao> transacoes){
        Assert.notNull(transacoes, "A lista de transações não pode ser nula");
        return transacoes.stream().map(Transacao::toResponse).collect(Collectors.toList());
    }
}
