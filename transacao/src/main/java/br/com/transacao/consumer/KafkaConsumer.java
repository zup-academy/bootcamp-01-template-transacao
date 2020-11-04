package br.com.transacao.consumer;

import br.com.transacao.dtos.TransacaoResponse;
import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.TransacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    private final TransacaoRepository transacaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);


    public KafkaConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


    @KafkaListener(topics="transacoes", groupId = "group_json", containerFactory = "transacaoKafkaListenerFactory")
    public void consume(String transacaoEnviadaViaKafkaTopic) throws InterruptedException, JsonProcessingException {

        /* coloquei só pra não demandar tanto do computador, mas vou pensar em alguma outra forma de lidar
        * com a frequência alta dos envios do topic */
        Thread.sleep(3000);


        /* está servindo só para debugar por enquanto, mas vou retirar esse system out depois*/
        System.out.println(transacaoEnviadaViaKafkaTopic);


        var transacaoRecebida =
                new ObjectMapper().readValue(transacaoEnviadaViaKafkaTopic, TransacaoResponse.class);

        var transacao = transacaoRecebida.toModel();

        logger.info("Transacao feita por={}, efetivada em={} no estabelecimento={]",
                transacao.retornaEmailDoComprador(), transacao.getEfetivadaEm(), transacao.retornaNomeEstabelecimento());


        transacaoRepository.save(transacao);

    }
}
