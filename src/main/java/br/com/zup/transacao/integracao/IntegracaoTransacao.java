package br.com.zup.transacao.integracao;

import br.com.zup.transacao.listener.TransacaoListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class IntegracaoTransacao {

    private EntityManager entityManager;

    public IntegracaoTransacao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvirKafka(TransacaoListener response) {
        Assert.notNull(response, "A resposta de transação não pode ser nula");
        entityManager.persist(response.toModel());
    }
}
