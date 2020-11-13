package br.com.itau.transacao.config;

import br.com.itau.transacao.model.EventoDeTransacaoListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/*
    RESUMO: PRIMEIRO TEVE QUE TRANSCREVER AS PROPRIEDADES DO CONSUMIDOR PARA UM MAPA, QUE FOI UTILIZADO PARA DEFINIR NOSSO CONSUMIDOR
E POR ÚLTIMO FOI CADASTRADO O NOSSO CONSUMIDOR NO LISTENER.
 */
@Configuration
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

//    ADICIONANDO PROPRIEDADES DO CONSUMIDOR
    public Map<String, Object> consumerConfiguration() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

        return properties;
    }

/*
    MÉTODO CONFIGURADO EM DUAS ETAPAS:
        1º - DEFINIR QUEM SERÁ O DESERIALIZADOR DA CHAVE E DO EVENTO DA MENSAGEM (NO CASO STRINGDESERIALIZER, JSONDESERIALIZER)
        2º - QUAIS SÃO AS CONFIGURAÇÕES DESSE CONSUMIDOR, POR ESTE MOTIVO FOI CRIADO O MÉTODO CONSUMERCONFIGURATION
*/
    @Bean
    public ConsumerFactory<String, EventoDeTransacaoListener> transacaoConsumerFactory() {
        StringDeserializer stringDeserializer = new StringDeserializer();
        JsonDeserializer<EventoDeTransacaoListener> jsonDeserializer = new JsonDeserializer<>(EventoDeTransacaoListener.class, false);

        return new DefaultKafkaConsumerFactory<>(consumerConfiguration(), stringDeserializer, jsonDeserializer);
    }

/*
    FOI CRIADO O ConcurrentKafkaListenerContainerFactory NO QUAL PRECISA SER CADASTRADO COMO ELE IRÁ TRATAR OS EVENTOS RECEBIDOS,
POR ISSO FOI CRIADO O MÉTODO transacaoConsumerFactory().
 */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacaoListener> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacaoListener> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transacaoConsumerFactory());

        return factory;
    }
}
