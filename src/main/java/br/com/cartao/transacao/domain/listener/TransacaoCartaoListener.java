package br.com.cartao.transacao.domain.listener;

import br.com.cartao.transacao.domain.model.Cartao;
import br.com.cartao.transacao.domain.model.EstabelecimentoCompra;
import br.com.cartao.transacao.domain.model.TransacaoCartao;
import br.com.cartao.transacao.repository.CartaoRepository;
import br.com.cartao.transacao.utils.Encoder;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransacaoCartaoListener {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoCompraListener estabelecimento;

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

    public TransacaoCartao toModel(CartaoRepository cartaoRepository){
        List<Cartao> cartaoSolicitado = cartaoRepository.findAll().stream()
                .filter(cartao ->
                        Encoder.decode(cartao.getCartaoId()).equals(this.cartao.getId())
                ).collect(Collectors.toList());

        Assert.notEmpty(cartaoSolicitado,"Cartão não encontrado na base de dados. ");

        EstabelecimentoCompra estabelecimentoCompra = this.estabelecimento.toModel();
        return new TransacaoCartao(this.id,this.valor,estabelecimentoCompra, cartaoSolicitado.get(0), LocalDateTime.parse(this.efetivadaEm));
    }
}


