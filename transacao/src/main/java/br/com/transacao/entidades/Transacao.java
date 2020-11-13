package br.com.transacao.entidades;

import br.com.transacao.dtos.CartaoDto;
import br.com.transacao.repositories.CartaoRepository;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Entity
public class Transacao {

    /* pontos de dificuldade de entendimento -> 5 */

    @Id
    private String id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private LocalDateTime efetivadaEm;

    /* @complexidade (1) - classe específica */
    @NotNull
    @ManyToOne
    private Cartao cartao;

    /* @complexidade (1) - classe específica */
    @NotNull
    @Embedded
    private  Estabelecimento estabelecimento;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, String efetivadaEm,
                     Cartao cartao, Estabelecimento estabelecimento) {

        this.id = id;
        this.valor = valor;
        this.efetivadaEm = converteParaLocalDateTime(efetivadaEm);
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;

    }

    /* @complexidade (1) - método específico */
    public LocalDateTime converteParaLocalDateTime(String efetivadaEm){

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss")
                .withZone(ZoneId.of("UTC"));

        return LocalDateTime.parse(efetivadaEm, formatter);

    }

    /* @complexidade (1) - método específico */
    public String retornaEmailDoComprador(){
        return this.cartao.getEmail();
    }

    /* @complexidade (1) - método específico */
    public String retornaNomeEstabelecimento(){
        return this.estabelecimento.getNome();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }


}
