package dev.arielalvesdutra.transacao.controllers.dtos;

import dev.arielalvesdutra.transacao.entities.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseDTO {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponseDTO estabelecimento;

    public TransacaoResponseDTO() {}

    public TransacaoResponseDTO(Transacao transacao) {
        setId(transacao.getId());
        setValor(transacao.getValor());
        setEfetivadaEm(transacao.getEfetivadaEm());
        setEstabelecimento(new EstabelecimentoResponseDTO(transacao.getEstabelecimento()));
    }

    public String getId() {
        return id;
    }

    public TransacaoResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoResponseDTO setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoResponseDTO setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
        return this;
    }

    public EstabelecimentoResponseDTO getEstabelecimento() {
        return estabelecimento;
    }

    public TransacaoResponseDTO setEstabelecimento(EstabelecimentoResponseDTO estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }

    public static Page<TransacaoResponseDTO> toDTO(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoResponseDTO::new);
    }
}
