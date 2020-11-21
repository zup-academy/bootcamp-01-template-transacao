package br.com.zup.transacao.cartao;

public class CartaoListenerResponse {

    private String id;
    private String email;
    //1
    public Cartao toCartao(){
        return new Cartao(id, email);
    }
}
