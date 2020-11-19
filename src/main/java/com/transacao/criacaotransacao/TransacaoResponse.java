package com.transacao.criacaotransacao;

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

    public EstabelecimentoResponse getEstabelecimentoResponse() {
        return estabelecimentoResponse;
    }

    public CartaoResponse getCartaoResponse() {
        return cartaoResponse;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
