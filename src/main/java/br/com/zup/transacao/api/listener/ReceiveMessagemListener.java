package br.com.zup.transacao.api.listener;

import br.com.zup.transacao.domain.entity.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReceiveMessagemListener {

    private UUID id;
    private BigDecimal valor;
    private ReceiveEstabelecimentoListener receiveEstabelecimentoListener;
    private ReceiveCartaoListener receiveCartaoListener;
    private LocalDateTime efetivadaEm;

    public Transacao toTransacao(){
        return new Transacao(id, valor, receiveEstabelecimentoListener.toEstabelecimento(), receiveCartaoListener.toCartao(), efetivadaEm);
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

    public ReceiveEstabelecimentoListener getEstabelecimento() {
        return receiveEstabelecimentoListener;
    }

    public void setEstabelecimento(ReceiveEstabelecimentoListener receiveEstabelecimentoListener) {
        this.receiveEstabelecimentoListener = receiveEstabelecimentoListener;
    }

    public ReceiveCartaoListener getCartao() {
        return receiveCartaoListener;
    }

    public void setCartao(ReceiveCartaoListener receiveCartaoListener) {
        this.receiveCartaoListener = receiveCartaoListener;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

}
