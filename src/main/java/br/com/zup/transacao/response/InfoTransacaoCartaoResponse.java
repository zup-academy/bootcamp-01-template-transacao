package br.com.zup.transacao.response;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InfoTransacaoCartaoResponse {

    @JsonProperty("id")
    private String numeroTransacao;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public InfoTransacaoCartaoResponse(){}

    public InfoTransacaoCartaoResponse(String numeroTransacao,
                                       BigDecimal valor, Estabelecimento estabelecimento,
                                       Cartao cartao, LocalDateTime efetivadaEm) {
        this.numeroTransacao = numeroTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getNumeroTransacao() {
        return numeroTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "InfoTransacaoCartaoResponse{" +
                "numeroTransacao='" + numeroTransacao + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
