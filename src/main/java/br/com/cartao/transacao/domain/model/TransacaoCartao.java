package br.com.cartao.transacao.domain.model;

import br.com.cartao.transacao.utils.Encoder;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class TransacaoCartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotBlank
    private String idTransacaoLegado;
    @NotNull
    private BigDecimal valor;
    @Embedded
    private EstabelecimentoCompra estabelecimento;
    @ManyToOne
    private Cartao cartao;
    @NotBlank
    private String email;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoCartao() {
    }

    public TransacaoCartao(String idTransacaoListener, BigDecimal valor, EstabelecimentoCompra estabelecimento, Cartao cartao, String email, LocalDateTime efetivadaEm) {
        this.idTransacaoLegado = idTransacaoListener;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}
