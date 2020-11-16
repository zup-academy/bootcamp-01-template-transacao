package com.transacao.criacaotransacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacoesController {

    @GetMapping
    public void buscaTransacoes() {
        return;
    }
}
