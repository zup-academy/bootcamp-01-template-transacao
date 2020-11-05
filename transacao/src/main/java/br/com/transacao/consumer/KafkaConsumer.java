package br.com.transacao.consumer;

import br.com.transacao.dtos.RecebeTransacaoKafka;
import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.CartaoRepository;
import br.com.transacao.repositories.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {


    private final TransacaoRepository transacaoRepository;

    private final CartaoRepository cartaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);



    public KafkaConsumer(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }


    @KafkaListener(topics="${spring.kafka.topic.transactions}", groupId = "proposta")
    public void consume(RecebeTransacaoKafka transacaoRecebida) {

        var transacao = transacaoRecebida.toModel(cartaoRepository);

        transacaoRepository.save(transacao);

        logger.info("[TRANSAÇÃO] Transacao feita por = {}, efetivada em = {} no estabelecimento = {}.",
                transacao.retornaEmailDoComprador(), transacao.getEfetivadaEm(), transacao.retornaNomeEstabelecimento());

    }
}
