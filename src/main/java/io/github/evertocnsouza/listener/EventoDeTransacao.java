package io.github.evertocnsouza.listener;

import io.github.evertocnsouza.entity.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventoDeTransacao {

    private UUID id;
    private BigDecimal valor;
    private EstabelecimentoListener estabelecimento;
    private CartaoListener cartao;
    private LocalDateTime efetivadaEm;
    private Logger log = LoggerFactory.getLogger(EventoDeTransacao.class);


    public Transacao toTransacao(){
        log.info("Chegou em transação");
        return new Transacao(id, valor, estabelecimento.toEstabelecimento(), cartao.toCartao(), efetivadaEm);
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

    public EstabelecimentoListener getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoListener estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoListener getCartao() {
        return cartao;
    }

    public void setCartao(CartaoListener cartao) {
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
        return "EventoDeTransacao{" +
                "id=" + id +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
