package com.transacao.criacaotransacao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String idTransacao;

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

    public Transacoes(String idTransacao, @NotNull @Positive BigDecimal valor, @NotNull Estabelecimento estabelecimento,
                      @NotNull Cartao cartao, LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
//Lista de transacoes?
}
