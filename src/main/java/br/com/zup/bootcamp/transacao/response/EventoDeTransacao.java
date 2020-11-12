package br.com.zup.bootcamp.transacao.response;

import java.math.BigDecimal;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
