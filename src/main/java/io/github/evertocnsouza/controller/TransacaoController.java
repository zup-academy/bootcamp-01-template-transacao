package io.github.evertocnsouza.controller;

import io.github.evertocnsouza.entity.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    @Value("${resultados.quantidade.maxima}")
    private int quantidadeMaximaDeResultados;

    private final Logger log = LoggerFactory.getLogger(TransacaoController.class);

    @GetMapping("/{idCartao}")
    public ResponseEntity consultarTransacoesDoCartao(@PathVariable UUID idCartao){

        List<Transacao> transacoes = manager.createNamedQuery("findTransacoesPorCartao", Transacao.class)
                .setParameter("idCartao", idCartao)
                .setMaxResults(quantidadeMaximaDeResultados)
                .getResultList();

        if(transacoes.isEmpty()){
            log.warn("Este cartão não tem transações {}", idCartao);
            Map response = new HashMap();
            response.put("mensagem", "Nenhuma transação foi encontrada para o cartão " + idCartao);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(Transacao.toResponseList(transacoes));
    }
}