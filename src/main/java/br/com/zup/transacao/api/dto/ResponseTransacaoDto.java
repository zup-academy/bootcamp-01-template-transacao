package br.com.zup.transacao.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResponseTransacaoDto {
    private final BigDecimal valor;
    private final ResponseEstabelecimentoDto estabelecimento;
    private final ResponseCartaoDto cartao;
    private final LocalDateTime efetivadaEm;

    public ResponseTransacaoDto(BigDecimal valor, ResponseEstabelecimentoDto estabelecimento, ResponseCartaoDto cartao,
                                LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ResponseEstabelecimentoDto getEstabelecimentoResponse() {
        return estabelecimento;
    }

    public ResponseCartaoDto getCartaoResponse() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
