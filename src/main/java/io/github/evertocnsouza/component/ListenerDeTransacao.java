package io.github.evertocnsouza.component;

import io.github.evertocnsouza.listener.EventoDeTransacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    @PersistenceContext
    EntityManager manager;

    private Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoDeTransacao transacaoResponse) {
        logger.info("Entrou no metodo ouvir");
        System.out.println(transacaoResponse.toString()); // Confirmação no console
        manager.persist(transacaoResponse.toTransacao());
        logger.info("Saiu do metodo ouvir");
    }

}