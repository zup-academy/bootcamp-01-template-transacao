package com.transacao.criacaotransacao;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
public class TransacoesListener {

    @Autowired
    private EntityManager manager;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(@Payload @NotNull TransacaoResponseListener transacaoResponse) {
        Transacoes transacao = transacaoResponse.toTransacao();
        manager.persist(transacao);
    }
}
