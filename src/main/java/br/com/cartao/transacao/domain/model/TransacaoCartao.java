package br.com.cartao.transacao.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class TransacaoCartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String idTransacaoLegado;

    private BigDecimal valor;
    @Embedded
    private EstabelecimentoCompra estabelecimento;
    @ManyToOne
    private Cartao cartao;
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoCartao() {
    }

    public TransacaoCartao(String idTransacaoListener, BigDecimal valor, EstabelecimentoCompra estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idTransacaoLegado = idTransacaoListener;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public String getIdTransacaoLegado() {
        return idTransacaoLegado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoCompra getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
