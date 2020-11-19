package dev.arielalvesdutra.transacao.kafka;

import dev.arielalvesdutra.transacao.configs.dtos.TransacaoMessageDTO;
import dev.arielalvesdutra.transacao.services.TransacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    private final Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @Autowired
    private TransacaoService transcaoService;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMessageDTO transacaoMessageDTO) {
        logger.info("Processando mensagem de transação com ID {}.", transacaoMessageDTO.getId());
        transcaoService.cadastrar(transacaoMessageDTO);
        logger.info("Processada mensagem de transação com ID {}.", transacaoMessageDTO.getId());
    }
}
