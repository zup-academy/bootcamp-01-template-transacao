package br.com.zup.transacao.cartao;

public class CartaoResponse {

    private String idCartao;
    private String email;

    public CartaoResponse(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }
}
