package br.com.zup.transacao.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
    }
}
