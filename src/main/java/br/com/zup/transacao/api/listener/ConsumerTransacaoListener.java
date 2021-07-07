package br.com.zup.transacao.api.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Component
public class ConsumerTransacaoListener {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(ReceiveMessagemListener transacao) {
        Assert.notNull(transacao, "A resposta de transação não pode ser nula");
        entityManager.persist(transacao.toTransacao());
    }
}
