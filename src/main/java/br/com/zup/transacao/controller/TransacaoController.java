package br.com.zup.transacao.controller;

import br.com.zup.transacao.model.Transacao;
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

    public TransacaoController(EntityManager entityManager,  @Value("${resultados.quantidade.maxima}") int quantidadeMaximaDeResultados) {
        this.entityManager = entityManager;
        this.quantidadeMaximaDeResultados = quantidadeMaximaDeResultados;
    }

    @GetMapping("/{cartaoID}")
    public ResponseEntity consultarTransacoesDoCartao(@PathVariable UUID cartaoID){
        List<Transacao> transacoes = entityManager.createNamedQuery("findTransacoesPorCartao", Transacao.class)
                .setParameter("cartaoID", cartaoID)
                .setMaxResults(quantidadeMaximaDeResultados)
                .getResultList();

        if(transacoes.isEmpty()){
            Map response = new HashMap();
            response.put("mensagem", "Nenhuma transação foi encontrada para o cartão " + cartaoID);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(Transacao.toResponseList(transacoes));
    }
}
