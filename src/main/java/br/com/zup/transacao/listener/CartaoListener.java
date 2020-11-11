package br.com.zup.transacao.listener;

import br.com.zup.transacao.model.Cartao;

import java.util.UUID;

public class CartaoListener {

    private UUID id;
    private String email;

    public Cartao toModel(){
        return new Cartao(id, email);
    }
}
