package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.CartaoListenerResponse;
import br.com.zup.transacao.estabelecimento.EstabelecimentoListenerResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoListenerResponse {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoListenerResponse estabelecimentoListenerResponse;
    private CartaoListenerResponse cartaoListenerResponse;
    private LocalDateTime efetivadaEm;

    public Transacao toTransacao() {
        return new Transacao(id, valor, estabelecimentoListenerResponse.toModel(),
                cartaoListenerResponse.toModel(), efetivadaEm);
    }

    @Override
    public String toString() {
        return "TransacaoListenerResponse{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimentoListenerResponse=" + estabelecimentoListenerResponse +
                ", cartaoListenerResponse=" + cartaoListenerResponse +
                ", efetivadaEm=" + efetivadaEm +
                '}';
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

    public EstabelecimentoListenerResponse getEstabelecimentoListenerResponse() {
        return estabelecimentoListenerResponse;
    }

    public void setEstabelecimentoListenerResponse(EstabelecimentoListenerResponse estabelecimentoListenerResponse) {
        this.estabelecimentoListenerResponse = estabelecimentoListenerResponse;
    }

    public CartaoListenerResponse getCartaoListenerResponse() {
        return cartaoListenerResponse;
    }

    public void setCartaoListenerResponse(CartaoListenerResponse cartaoListenerResponse) {
        this.cartaoListenerResponse = cartaoListenerResponse;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
