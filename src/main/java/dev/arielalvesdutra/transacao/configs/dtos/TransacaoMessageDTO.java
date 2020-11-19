package dev.arielalvesdutra.transacao.configs.dtos;

import dev.arielalvesdutra.transacao.entities.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Mensagem esperada do consumer de "transacoes".
 */
public class TransacaoMessageDTO {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private TransacaoMessageCartaoDTO cartao;
    private TransacaoMessageEstabelecimentoDTO estabelecimento;

    public TransacaoMessageDTO() {
    }

    public String getId() {
        return id;
    }

    public TransacaoMessageDTO setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoMessageDTO setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoMessageDTO setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
        return this;
    }

    public TransacaoMessageCartaoDTO getCartao() {
        return cartao;
    }

    public TransacaoMessageDTO setCartao(TransacaoMessageCartaoDTO cartao) {
        this.cartao = cartao;
        return this;
    }

    public TransacaoMessageEstabelecimentoDTO getEstabelecimento() {
        return estabelecimento;
    }

    public TransacaoMessageDTO setEstabelecimento(TransacaoMessageEstabelecimentoDTO estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    @Override
    public String toString() {
        return "TransacaoMessageDTO{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", cartao=" + cartao +
                ", estabelecimento=" + estabelecimento +
                '}';
    }

    public Transacao paraEntidade() {
        return new Transacao()
                .setLegadoId(id)
                .setValor(valor)
                .setEfetivadaEm(efetivadaEm)
                .setEstabelecimento(estabelecimento.paraEmbeddable());
    }
}
