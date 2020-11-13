package br.com.transacao.dtos;

import br.com.transacao.entidades.Cartao;
import br.com.transacao.entidades.Estabelecimento;
import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.CartaoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class RecebeTransacaoKafka {


    @NotBlank
    private String id;

    @NotNull
    private BigDecimal valor;

    @NotBlank
    private String efetivadaEm;

    @NotNull
    private CartaoDto cartao;

    @NotNull
    private Estabelecimento estabelecimento;


    @Deprecated
    public RecebeTransacaoKafka(){}

    public RecebeTransacaoKafka(@NotBlank String id, @NotNull BigDecimal valor, @NotBlank String efetivadaEm,
                                @NotNull CartaoDto cartao, @NotNull Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }

    public Transacao toModel(CartaoRepository cartaoRepository){

        var cartaoRecebido = this.cartao.toModel();

        if(cartaoRepository.findById(this.cartao.getId()).isEmpty()){
            cartaoRepository.save(cartaoRecebido);
        }

        return new Transacao(id, valor, efetivadaEm, cartaoRecebido, estabelecimento);

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
