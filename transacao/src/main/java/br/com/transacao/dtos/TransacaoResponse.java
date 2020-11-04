package br.com.transacao.dtos;

import br.com.transacao.entidades.Cartao;
import br.com.transacao.entidades.Estabelecimento;
import br.com.transacao.entidades.Transacao;

import java.math.BigDecimal;


public class TransacaoResponse {

    private String id;

    private BigDecimal valor;

    private String efetivadaEm;

    private Cartao cartao;

    private Estabelecimento estabelecimento;

    @Deprecated
    public TransacaoResponse(){}

    public TransacaoResponse(String id, BigDecimal valor,
                             String efetivadaEm, Cartao cartao, Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }

    public Transacao toModel(){

        return new Transacao(id, valor, efetivadaEm, cartao, estabelecimento);

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

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(String efetivadaEm) {
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
