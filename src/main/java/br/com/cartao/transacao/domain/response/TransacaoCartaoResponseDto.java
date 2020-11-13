package br.com.cartao.transacao.domain.response;

import br.com.cartao.transacao.domain.model.EstabelecimentoCompra;
import br.com.cartao.transacao.domain.model.TransacaoCartao;
import br.com.cartao.transacao.utils.Encoder;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoCartaoResponseDto {

    private String id;
    @NotBlank
    private String idTransacaoLegado;
    @NotNull
    private BigDecimal valor;
    @Embedded
    private EstabelecimentoCompra estabelecimento;
    @NotBlank
    private String idCartao;
    @NotBlank
    private String email;
    private LocalDateTime efetivadaEm;

    public TransacaoCartaoResponseDto(TransacaoCartao transacaoCartao) {
        String decode = Encoder.decode(transacaoCartao.getIdCartao());
        this.id = transacaoCartao.getId();
        this.idTransacaoLegado = transacaoCartao.getIdTransacaoLegado();
        this.valor = transacaoCartao.getValor();
        this.estabelecimento = transacaoCartao.getEstabelecimento();
        this.idCartao = decode.substring(0,3).concat("**********").concat(decode.substring(decode.length()-3, decode.length()));
        this.email = transacaoCartao.getEmail();
        this.efetivadaEm = transacaoCartao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public TransacaoCartaoResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getIdTransacaoLegado() {
        return idTransacaoLegado;
    }

    public TransacaoCartaoResponseDto setIdTransacaoLegado(String idTransacaoLegado) {
        this.idTransacaoLegado = idTransacaoLegado;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoCartaoResponseDto setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public EstabelecimentoCompra getEstabelecimento() {
        return estabelecimento;
    }

    public TransacaoCartaoResponseDto setEstabelecimento(EstabelecimentoCompra estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public TransacaoCartaoResponseDto setIdCartao(String idCartao) {
        this.idCartao = idCartao;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TransacaoCartaoResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoCartaoResponseDto setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
        return this;
    }
}
