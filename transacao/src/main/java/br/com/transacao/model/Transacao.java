package br.com.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Contagem de Pontos - TOTAL:0


@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String idCartao;
	private BigDecimal valor;
	private LocalDateTime instante;
	private String email;
	
	@Deprecated
	public Transacao() {
	}

	public Transacao(String idCartao, BigDecimal valor, LocalDateTime instante, String email) {
		super();
		this.idCartao = idCartao;
		this.valor = valor;
		this.instante = instante;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", idCartao=" + idCartao + ", valor=" + valor + ", instante=" + instante
				+ ", email=" + email + "]";
	}
}
