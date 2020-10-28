package com.marcoscoutozup.transacao.transacao;

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
    @Transactional      //1
    public void ouvir(TransacaoResponseListener transacaoResponse) {
        Assert.notNull(transacaoResponse, "A resposta de transação não pode ser nula");
        entityManager.persist(transacaoResponse.toTransacao());
    }
}
