package br.com.zup.transacao.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;

    private EstabelecimentoResponse estabelecimentoResponse;

    private CartaoResponse cartaoResponse;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(BigDecimal valor, EstabelecimentoResponse estabelecimentoResponse, CartaoResponse cartaoResponse, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimentoResponse = estabelecimentoResponse;
        this.cartaoResponse = cartaoResponse;
        this.efetivadaEm = efetivadaEm;
    }
}
