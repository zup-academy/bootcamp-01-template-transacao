package br.com.zup.transacao.transacao;

import br.com.zup.transacao.cartao.Cartao;
import br.com.zup.transacao.estabelecimento.Estabelecimento;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private @NotBlank String idTransacao;
    private @NotNull @Positive BigDecimal valor;
    private @NotNull @Embedded Estabelecimento estabelecimento;
    private @NotNull @Embedded Cartao cartao;
    private @NotNull LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String idTransacao, @NotNull BigDecimal valor,
                     @NotNull Estabelecimento estabelecimento, @NotNull Cartao cartao,
                     @NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toResponse() {
        return new TransacaoResponse(valor, estabelecimento.toResponse(), cartao.toResponse(), efetivadaEm);
    }

    public static List<TransacaoResponse> toResponseList(List<Transacao> transacoes) {
        return transacoes.stream().map(Transacao::toResponse).collect(Collectors.toList());
    }
}
