package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.CartaoResponse;
import br.com.zup.transacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimentoResponse;
    private CartaoResponse cartaoResponse;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(BigDecimal valor, EstabelecimentoResponse estabelecimentoResponse,
                             CartaoResponse cartaoResponse, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimentoResponse = estabelecimentoResponse;
        this.cartaoResponse = cartaoResponse;
        this.efetivadaEm = efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoResponse getEstabelecimentoResponse() {
        return estabelecimentoResponse;
    }

    public void setEstabelecimentoResponse(EstabelecimentoResponse estabelecimentoResponse) {
        this.estabelecimentoResponse = estabelecimentoResponse;
    }

    public CartaoResponse getCartaoResponse() {
        return cartaoResponse;
    }

    public void setCartaoResponse(CartaoResponse cartaoResponse) {
        this.cartaoResponse = cartaoResponse;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }
}
