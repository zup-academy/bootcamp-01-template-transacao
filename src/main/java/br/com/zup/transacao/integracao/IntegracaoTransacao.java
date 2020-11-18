package br.com.zup.transacao.integracao;

import br.com.zup.transacao.listener.TransacaoListener;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class IntegracaoTransacao {

    private final TransacaoRepository transacaoRepository;
    private final CartaoRepository cartaoRepository;

    public IntegracaoTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvirKafka(TransacaoListener response) {
        var transacao = response.toModel(cartaoRepository);
        transacaoRepository.save(transacao);
    }
}
