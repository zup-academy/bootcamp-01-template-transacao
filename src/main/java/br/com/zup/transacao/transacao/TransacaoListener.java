package br.com.zup.transacao.transacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class TransacaoListener {

    private EntityManager entityManager;

    public TransacaoListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoListenerResponse transacaoListenerResponse) {
        Assert.notNull(transacaoListenerResponse, "A resposta de transação não pode ser nula");
        entityManager.persist(transacaoListenerResponse.toTransacao());
    }
}
