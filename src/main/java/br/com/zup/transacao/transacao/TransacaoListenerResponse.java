package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.CartaoListenerResponse;
import br.com.zup.transacao.estabelecimento.EstabelecimentoListenerResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoListenerResponse {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoListenerResponse estabelecimento;
    private CartaoListenerResponse cartao;
    private LocalDateTime efetivadaEm;

    public Transacao toModel() {
        return new Transacao(id, valor, estabelecimento.toModel(),
                cartao.toModel(), efetivadaEm);
    }

    @Override
    public String toString() {
        return "TransacaoListenerResponse{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimentoListenerResponse=" + estabelecimento +
                ", cartaoListenerResponse=" + cartao +
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

    public EstabelecimentoListenerResponse getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoListenerResponse estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoListenerResponse getCartao() {
        return cartao;
    }

    public void setCartao(CartaoListenerResponse cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
