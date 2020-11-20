package br.com.zup.transacao.request;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.InfoTransacaoCartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InfoTransacaoCartaoRequest {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public InfoTransacaoCartaoRequest(){}

    public InfoTransacaoCartaoRequest(String id, BigDecimal valor,
                                      EstabelecimentoRequest estabelecimento,
                                      CartaoRequest cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public InfoTransacaoCartao toInfoTransacaoCartao(){
        Cartao novoCartao = this.cartao.toCartao();
        Estabelecimento novoEstabelecimento = this.estabelecimento.toEstabelecimento();
        return new InfoTransacaoCartao(this.id, this.valor, novoEstabelecimento, novoCartao, this.efetivadaEm);
    }

}
