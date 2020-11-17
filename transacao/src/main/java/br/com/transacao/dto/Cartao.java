package br.com.transacao.dto;

//Contagem de Pontos - TOTAL:0

public class Cartao {

	private String id;
	private String email;
	
	
	public Cartao() {
	}
	
	public Cartao(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
	
	
	
}
