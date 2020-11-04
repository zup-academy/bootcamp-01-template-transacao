package br.com.transacao.entidades;

import br.com.transacao.dtos.CartaoDto;
import br.com.transacao.repositories.CartaoRepository;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
;


@Entity
public class Transacao {

    @Id
    private String id;

    @NotNull
    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @NotNull
    @ManyToOne
    private Cartao cartao;

    @NotNull
    @Embedded
    private  Estabelecimento estabelecimento;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, String efetivadaEm,
                     CartaoDto cartao, Estabelecimento estabelecimento, CartaoRepository cartaoRepository) {

        this.id = id;
        this.valor = valor;
        this.efetivadaEm = converteParaLocalDateTime(efetivadaEm);
        this.cartao = salvaCartaoRecebidoPeloTopic(cartao, cartaoRepository);
        this.estabelecimento = estabelecimento;

    }

    public LocalDateTime converteParaLocalDateTime(String efetivadaEm){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
                .withZone(ZoneId.of("UTC"));

        LocalDateTime date = LocalDateTime.parse(efetivadaEm, formatter);

        return date;

    }

    public Cartao salvaCartaoRecebidoPeloTopic(CartaoDto cartaoDto, CartaoRepository cartaoRepository){
        cartaoRepository.save(cartaoDto.toModel());
        return  cartaoDto.toModel();
    }


    public String retornaEmailDoComprador(){
        return this.cartao.getEmail();
    }

    public String retornaNomeEstabelecimento(){
        return this.estabelecimento.getNome();
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

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
