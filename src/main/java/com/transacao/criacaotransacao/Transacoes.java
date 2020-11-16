package com.transacao.criacaotransacao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacoes {

    @Id
    private String id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Estabelecimento estabelecimento;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacoes() {

    }

    public Transacoes(String id, @NotNull @Positive BigDecimal valor, @NotNull Estabelecimento estabelecimento,
                      @NotNull Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    //Lista de transacoes?
}
