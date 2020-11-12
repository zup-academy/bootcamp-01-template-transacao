package br.com.zup.bootcamp.transacao.config;

import br.com.zup.bootcamp.transacao.response.EventoDeTransacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        logger.info("Id: {} - valor: {}", eventoDeTransacao.getId(), eventoDeTransacao.getValor());
    }
}

