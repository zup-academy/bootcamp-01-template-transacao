package com.transacao.criacaotransacao;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseListener {

    @NotNull
    private String id;

    @NotNull
    private BigDecimal valor;

    private EstabelecimentoResponseListener estabelecimento;

    private CartaoResponseListener cartao;

    private LocalDateTime efetivadaEm;

    public Transacoes toTransacao(){
        return new Transacoes(id, valor, estabelecimento.toEstabelecimento(),
                cartao.toCartao(), efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoResponseListener getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoResponseListener estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoResponseListener getCartao() {
        return cartao;
    }

    public void setCartao(CartaoResponseListener cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
