package com.transacao.criacaotransacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idCartao;

    @NotBlank
    private String email;

    public Cartao() {

    }

    public Cartao(String idCartao, String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

     public CartaoResponse toResponse() {
         return new CartaoResponse(this.idCartao, this.email);
     }
}
