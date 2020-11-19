package br.com.cartao.transacao.domain.listener;

import br.com.cartao.transacao.domain.model.Cartao;
import br.com.cartao.transacao.domain.model.EstabelecimentoCompra;
import br.com.cartao.transacao.domain.model.TransacaoCartao;
import br.com.cartao.transacao.repository.CartaoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 9
 * Carga intrínseca da classe - 4
 */

public class TransacaoCartaoListener {

    private String id;

    private BigDecimal valor;
    // +1
    private EstabelecimentoCompraListener estabelecimento;
    // +1
    private CartaoListener cartao;
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss", shape = JsonFormat.Shape.STRING)
    private String efetivadaEm;

    public TransacaoCartaoListener() {
    }

    public TransacaoCartaoListener(String id, BigDecimal valor, EstabelecimentoCompraListener estabelecimento, CartaoListener cartao, String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public TransacaoCartaoListener setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoCartaoListener setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public EstabelecimentoCompraListener getEstabelecimento() {
        return estabelecimento;
    }

    public TransacaoCartaoListener setEstabelecimento(EstabelecimentoCompraListener estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    public CartaoListener getCartao() {
        return cartao;
    }

    public TransacaoCartaoListener setCartao(CartaoListener cartao) {
        this.cartao = cartao;
        return this;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoCartaoListener setEfetivadaEm(String efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
        return this;
    }

    @Override
    public String toString() {
        return "TransacaoCartaoEvento{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
    // +1
    public TransacaoCartao toModel(CartaoRepository cartaoRepository){
        Cartao cartao = cartaoRepository.findById(this.id).get();
        Assert.notNull(cartao,"Cartão não encontrado para o id.");

        // +1
        EstabelecimentoCompra estabelecimentoCompra = this.estabelecimento.toModel();
        return new TransacaoCartao(this.id,this.valor,estabelecimentoCompra, cartao, this.cartao.getEmail(), LocalDateTime.parse(this.efetivadaEm));
    }
}


