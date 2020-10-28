package com.marcoscoutozup.transacao.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final EntityManager entityManager;
    private final int quantidadeMaximaDeResultados;
    private final Logger log = LoggerFactory.getLogger(TransacaoController.class);

    public TransacaoController(EntityManager entityManager,  @Value("${resultados.quantidade.maxima}") int quantidadeMaximaDeResultados) {
        this.entityManager = entityManager;
        this.quantidadeMaximaDeResultados = quantidadeMaximaDeResultados;
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity consultarTransacoesDoCartao(@PathVariable UUID idCartao){
                //1
       List<Transacao> transacoes = entityManager.createNamedQuery("findTransacoesPorCartao", Transacao.class)
                .setParameter("idCartao", idCartao)
                .setMaxResults(quantidadeMaximaDeResultados)
                .getResultList();

        //2
        if(transacoes.isEmpty()){
            log.warn("[CONSULTAR TRANSAÇÕES] Nenhuma transação encontrada para o cartão {}", idCartao);
            Map response = new HashMap();
            response.put("mensagem", "Nenhuma transação foi encontrada para o cartão " + idCartao);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(Transacao.toResponseList(transacoes));
    }
}
