package br.com.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.transacao.model.Transacao;

//Contagem de Pontos - TOTAL:1
//1 - Transacao
//1 - Cartao

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private String efetivadaEm;
    private Cartao cartao;
    
    public EventoDeTransacao() {
    }
    
    public Transacao toModel() {
        String data = this.efetivadaEm.replace("T", " ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
        LocalDateTime dataFormatada = LocalDateTime.parse(data, formato); 
        
    	return new Transacao(this.id, this.valor, dataFormatada, cartao.getEmail());
    }

	

	public EventoDeTransacao(String id, BigDecimal valor, String efetivadaEm, Cartao cartao) {
		super();
		this.id = id;
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setId(String id) {
		this.id = id;
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

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	@Override
	public String toString() {
		return "EventoDeTransacao [id=" + id + ", valor=" + valor + ", efetivadaEm=" + efetivadaEm + ", cartao=" + cartao
				+ "]";
	}

	
}
