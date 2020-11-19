package br.com.cartao.transacao.listeners;

import br.com.cartao.transacao.domain.listener.CartaoPropostaListener;
import br.com.cartao.transacao.domain.model.Cartao;
import br.com.cartao.transacao.repository.CartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CartaoListener {

    private static Logger logger = LoggerFactory.getLogger(CartaoListener.class);

    private final CartaoRepository cartaoRepository;

    public CartaoListener(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.cartao}",containerFactory = "kafkaListenerContainerFactoryCartao")
    public void listener(CartaoPropostaListener cartaoPropostaListener){
        logger.info("Evento recebido com sucesso, com idCartao: {}", cartaoPropostaListener.getIdCartao());
        Cartao cartao = cartaoPropostaListener.toModel();

        cartaoRepository.save(cartao);
        logger.info("Evento cartão armazenado com sucesso, id: {}", cartao.getIdCartao());
    }
}
