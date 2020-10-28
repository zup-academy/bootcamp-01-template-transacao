package com.marcoscoutozup.transacao.transacao;

import com.marcoscoutozup.transacao.cartao.CartaoResponseListener;
import com.marcoscoutozup.transacao.estabelecimento.EstabelecimentoResponseListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponseListener {

    private UUID id;
    private BigDecimal valor;
            //1
    private EstabelecimentoResponseListener estabelecimentoResponseListener;
            //2
    private CartaoResponseListener cartaoResponseListener;
    private LocalDateTime efetivadaEm;

            //3
    public Transacao toTransacao(){
        return new Transacao(id, valor, estabelecimentoResponseListener.toEstabelecimento(), cartaoResponseListener.toCartao(), efetivadaEm);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoResponseListener getEstabelecimento() {
        return estabelecimentoResponseListener;
    }

    public void setEstabelecimento(EstabelecimentoResponseListener estabelecimentoResponseListener) {
        this.estabelecimentoResponseListener = estabelecimentoResponseListener;
    }

    public CartaoResponseListener getCartao() {
        return cartaoResponseListener;
    }

    public void setCartao(CartaoResponseListener cartaoResponseListener) {
        this.cartaoResponseListener = cartaoResponseListener;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

}
