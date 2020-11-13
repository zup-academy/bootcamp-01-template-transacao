package br.com.itau.transacao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CompraResponse {

    private final BigDecimal valor;
    @JsonProperty(value = "estabelecimento")
    private final EstabelecimentoResponse estabelecimentoResponse;
    @JsonProperty(value = "cartao")
    private final CartaoResponse cartaoResponse;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private final LocalDateTime efetivadaEm;

    public CompraResponse(BigDecimal valor, EstabelecimentoResponse estabelecimentoResponse, CartaoResponse cartaoResponse, LocalDateTime efetivadaEm) {
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

    public CompraResponse(Compra compra) {
        this.valor = compra.getValor();
        this.estabelecimentoResponse = new EstabelecimentoResponse(compra.getEstabelecimento().getNome(), compra.getEstabelecimento().getCidade(), compra.getEstabelecimento().getEndereco());
        this.cartaoResponse = new CartaoResponse(compra.getCartao().getEmail());
        this.efetivadaEm = compra.getEfetivadaEm();
    }
}
