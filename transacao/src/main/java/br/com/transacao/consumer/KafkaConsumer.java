package br.com.transacao.consumer;

import br.com.transacao.dtos.RecebeTransacaoKafka;
import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.CartaoRepository;
import br.com.transacao.repositories.TransacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    private final TransacaoRepository transacaoRepository;

    private final CartaoRepository cartaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);


    public KafkaConsumer(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }


    @KafkaListener(topics="transacoes", groupId = "group_json", containerFactory = "transacaoKafkaListenerFactory")
    public void consume(String transacaoEnviadaViaKafkaTopic) throws InterruptedException, JsonProcessingException {


        Thread.sleep(30000);

        System.out.println(transacaoEnviadaViaKafkaTopic);

        var transacaoRecebida =
                new ObjectMapper().readValue(transacaoEnviadaViaKafkaTopic, RecebeTransacaoKafka.class);

        var transacao = transacaoRecebida.toModel(cartaoRepository);

        logger.info("[REGISTRO DE COMPRA] Transacao feita por = {}, efetivada em = {} no estabelecimento = {}",
                transacao.retornaEmailDoComprador(), transacao.getEfetivadaEm(), transacao.retornaNomeEstabelecimento());

        transacaoRepository.save(transacao);

    }
}
