package br.com.transacao.dtos;

import br.com.transacao.entidades.Cartao;
import br.com.transacao.entidades.Estabelecimento;
import br.com.transacao.entidades.Transacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class TransacaoDto {


    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    private CartaoDto cartao;

    private Estabelecimento estabelecimento;


    public TransacaoDto(Transacao transacao) {
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.cartao = toDto(transacao.getCartao());
        this.estabelecimento = transacao.getEstabelecimento();
    }

    public CartaoDto toDto(Cartao cartao){
        return new CartaoDto(cartao.getId(), cartao.getEmail());
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

    public CartaoDto getCartao() {
        return cartao;
    }

    public void setCartao(CartaoDto cartao) {
        this.cartao = cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
