package br.com.zup.transacao.cartao;

import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.Embeddable;

@Embeddable
public class Cartao {

    private String idCartao;

    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }
    //1
    public CartaoResponse toResponse(){
        return new CartaoResponse(this.idCartao, this.email);
    }
}
