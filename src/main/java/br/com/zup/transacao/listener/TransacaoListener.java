package br.com.zup.transacao.listener;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoListener {

    private UUID id;

    private BigDecimal valor;

    private EstabelecimentoListener estabelecimento;

    private CartaoListener cartao;

    private String efetivadaEm;

    @Deprecated
    public TransacaoListener() {
    }

    public TransacaoListener(UUID id, BigDecimal valor, EstabelecimentoListener estabelecimento,
                             CartaoListener cartao, String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoListener getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoListener getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(CartaoRepository cartaoRepository) {

        Cartao cartao = this.cartao.toModel();

        if (cartaoRepository.findById(cartao.getId()).isEmpty()){
            cartaoRepository.save(cartao);
        }

        return new Transacao(id, valor, cartao, estabelecimento.toModel(), efetivadaEm);
    }

}
