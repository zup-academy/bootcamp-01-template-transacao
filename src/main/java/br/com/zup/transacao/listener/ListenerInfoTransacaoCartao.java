package br.com.zup.transacao.listener;


import br.com.zup.transacao.model.InfoTransacaoCartao;
import br.com.zup.transacao.request.InfoTransacaoCartaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ListenerInfoTransacaoCartao {

    @PersistenceContext
    private EntityManager entityManager;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(InfoTransacaoCartaoRequest request) {

        InfoTransacaoCartao novaInfoTransacaoCartao =
                request.toInfoTransacaoCartao();

        entityManager.persist(novaInfoTransacaoCartao);

        System.out.println(novaInfoTransacaoCartao.toString());

    }

}
