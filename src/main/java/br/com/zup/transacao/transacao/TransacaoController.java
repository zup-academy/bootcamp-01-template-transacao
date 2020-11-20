package br.com.zup.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity consultarTransacoes(@PathVariable String idCartao) {
        List<Transacao> transacoes = transacaoRepository
                .findTop10ByCartaoIdCartaoOrderByEfetivadaEmDesc(idCartao);

        if (transacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(Transacao.toResponseList(transacoes));
    }
}
