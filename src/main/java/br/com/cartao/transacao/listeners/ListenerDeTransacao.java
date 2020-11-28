package br.com.cartao.transacao.listeners;

import br.com.cartao.transacao.domain.listener.TransacaoCartaoListener;
import br.com.cartao.transacao.domain.model.TransacaoCartao;
import br.com.cartao.transacao.repository.CartaoRepository;
import br.com.cartao.transacao.repository.TransacaoCartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private static Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @Autowired
    private final CartaoRepository cartaoRepository;
    private final TransacaoCartaoRepository transacaoCartaoRepository;

    public ListenerDeTransacao(CartaoRepository cartaoRepository, TransacaoCartaoRepository transacaoCartaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoCartaoRepository = transacaoCartaoRepository;
    }


    @KafkaListener(topics = "${spring.kafka.topic.transactions}", containerFactory = "kafkaListenerContainerFactory")
    public void ouvir(TransacaoCartaoListener eventoDeTransacao) {
        logger.info("Evento transação recebido, idTransação: {}", eventoDeTransacao.getId());
        TransacaoCartao transacaoCartao = eventoDeTransacao.toModel(cartaoRepository);

        TransacaoCartao transacaoSalva = transacaoCartaoRepository.save(transacaoCartao);

        logger.info("Transacao salva com sucesso, id: {}", transacaoSalva.getId());
    }

}
