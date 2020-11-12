package br.com.cartao.transacao.domain.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoTransacaoRequest {

    @NotBlank
    private final String idCartao;
    @NotBlank @Email
    private final String email;

    public CartaoTransacaoRequest(@NotBlank String idCartao, @NotBlank @Email String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    public CartaoIntegracaoRequest toIntegracao(){
        return new CartaoIntegracaoRequest(this.idCartao, this.email);
    }
}
