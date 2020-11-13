package br.com.itau.transacao.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class EventoDeTransacaoListener {

    @NotBlank
    private String id;
    @NotNull
    private BigDecimal valor;
    @JsonProperty(value = "estabelecimento")
    private EstabelecimentoListener estabelecimentoListener;
    @JsonProperty(value = "cartao")
    private CartaoListener cartaoListener;
    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacaoListener() {
    }

    public EventoDeTransacaoListener(@NotBlank String id, @NotNull BigDecimal valor, EstabelecimentoListener estabelecimentoListener, CartaoListener cartaoListener, @NotNull LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimentoListener = estabelecimentoListener;
        this.cartaoListener = cartaoListener;
        this.efetivadaEm = efetivadaEm;
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

    public EstabelecimentoListener getEstabelecimentoListener() {
        return estabelecimentoListener;
    }

    public void setEstabelecimentoListener(EstabelecimentoListener estabelecimentoListener) {
        this.estabelecimentoListener = estabelecimentoListener;
    }

    public CartaoListener getCartaoListener() {
        return cartaoListener;
    }

    public void setCartaoListener(CartaoListener cartaoListener) {
        this.cartaoListener = cartaoListener;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Compra toModel() {
        return new Compra(this.id, this.valor.setScale(2, RoundingMode.HALF_DOWN), new Estabelecimento(this.estabelecimentoListener.getNome(),
                this.estabelecimentoListener.getCidade(), this.estabelecimentoListener.getEndereco()),
                new Cartao(this.cartaoListener.getId(), this.cartaoListener.getEmail()), this.efetivadaEm);
    }
}
