package io.github.evertocnsouza.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(BigDecimal valor,
                             EstabelecimentoResponse estabelecimento,
                             CartaoResponse cartao, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoResponse estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public void setCartao(CartaoResponse cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransacaoResponse{" +
                "valor=" + valor +
                ", estabelecimentoResponse=" + estabelecimento +
                ", cartaoResponse=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}