package io.github.evertocnsouza.entity;

import io.github.evertocnsouza.dto.TransacaoResponse;
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
        query = "SELECT t FROM Transacao t WHERE t.cartao.idCartao = :idCartao ORDER BY efetivadaEm DESC")
public class Transacao {

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    @NotNull
    private UUID idTransacao;

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

    public Transacao(@NotNull UUID idTransacao,
                     @NotNull @Positive BigDecimal valor,
                     @NotNull Estabelecimento estabelecimento,
                     @NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toResponse(){
        return new TransacaoResponse(this.valor, this.estabelecimento.toResponse(), this.cartao.toResponse(), this.efetivadaEm);
    }

    public static List<TransacaoResponse> toResponseList(List<Transacao> transacoes){
        return transacoes.stream().map(Transacao::toResponse).collect(Collectors.toList());
    }
}