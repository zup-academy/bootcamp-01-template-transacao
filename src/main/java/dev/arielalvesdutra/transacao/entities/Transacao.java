package dev.arielalvesdutra.transacao.entities;

import dev.arielalvesdutra.transacao.entities.embeddables.Estabelecimento;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotBlank(message = "ID do legado é obrigatório!")
    private String legadoId;
    @NotNull(message = "Valor é obrigatório!")
    private BigDecimal valor;
    @NotNull(message = "Efetivado Em é obrigatório!")
    private LocalDateTime efetivadaEm;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();

    @NotNull(message = "Estabelecimento é obrigatório!")
    @Embedded
    private Estabelecimento estabelecimento;

    @NotNull(message = "Cartão é obrigatório!")
    @ManyToOne
    private Cartao cartao;

    public Transacao() {
    }

    public String getId() {
        return id;
    }

    public Transacao setId(String id) {
        this.id = id;
        return this;
    }

    public String getLegadoId() {
        return legadoId;
    }

    public Transacao setLegadoId(String legadoId) {
        this.legadoId = legadoId;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Transacao setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Transacao setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Transacao setCartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Transacao setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", legadoId='" + legadoId + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", cadastradoEm=" + cadastradoEm +
                '}';
    }
}
