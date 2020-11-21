package br.com.zup.transacao.listener;

import br.com.zup.transacao.transacao.TransacaoListenerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class ListenerDeTransacao {

    private EntityManager manager;
    private Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    public ListenerDeTransacao(EntityManager manager) {
        this.manager = manager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoListenerResponse transacaoListenerResponse) {
        manager.persist(transacaoListenerResponse.toModel());
        logger.info("Transação salva");
    }
}
