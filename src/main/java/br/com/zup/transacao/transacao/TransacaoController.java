package br.com.zup.transacao.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private EntityManager entityManager;
    private final int quantidadeMaximaDeResultado;
    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    public TransacaoController(EntityManager entityManager, int quantidadeMaximaDeResultado) {
        this.entityManager = entityManager;
        this.quantidadeMaximaDeResultado = quantidadeMaximaDeResultado;
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity consultaTransacoesDoCartao(@PathVariable String idCartao){
        //1
        List<Transacao> transacoes = entityManager.createNamedQuery("findTransacoesPorCartao", Transacao.class)
                .setParameter("idCartao", idCartao)
                .setMaxResults(quantidadeMaximaDeResultado)
                .getResultList();

        if (transacoes.isEmpty()){
            logger.warn("[CONSULTAR TRANSAÇÕES] Nenhuma transação encontrada para o cartão, id {}", idCartao);
            Map response = new HashMap();
            response.put("mensagem", "Nenhuma transação foi encontrada para o cartão" + idCartao);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.ok(Transacao.toListResponse(transacoes));
    }


}
