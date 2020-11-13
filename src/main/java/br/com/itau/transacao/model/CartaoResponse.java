package br.com.itau.transacao.model;

public class CartaoResponse {

    private final String email;

    public CartaoResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
