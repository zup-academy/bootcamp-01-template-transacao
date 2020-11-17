package br.com.transacao.config;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.transacao.dto.EventoDeTransacao;

//Contagem de Pontos - TOTAL:1
//1 - EventoDeTransacao

@Component
public class ListenerDeTransacao {

	@PersistenceContext
	private EntityManager manager;
	
    @KafkaListener(topics = "transacoes")
    @Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) throws ParseException {
    	manager.persist(eventoDeTransacao.toModel());
        System.out.println(eventoDeTransacao.toString());
    }

}
