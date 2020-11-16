package br.com.zup.transacao.listener;

import br.com.zup.transacao.transacao.TransacaoListenerResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoListenerResponse transacaoListenerResponse) {
        System.out.println(transacaoListenerResponse.toString());
    }
}
