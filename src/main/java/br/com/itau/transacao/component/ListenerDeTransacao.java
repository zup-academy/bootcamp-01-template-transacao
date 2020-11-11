package br.com.itau.transacao.component;

import br.com.itau.transacao.model.Compra;
import br.com.itau.transacao.model.EventoDeTransacaoListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    private final EntityManager entityManager;

    public ListenerDeTransacao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir (EventoDeTransacaoListener eventoDeTransacaoListener) {
        logger.info("Evento id={} recebido com sucesso!", eventoDeTransacaoListener.getId());
        Compra compra = eventoDeTransacaoListener.toModel();

        entityManager.persist(compra);
        logger.info("Compra id={} valor={} cadastrada com sucesso!", compra.getId(), compra.getValor());
    }
}
