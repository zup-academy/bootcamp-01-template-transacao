package br.com.cartao.transacao.resource;

import br.com.cartao.transacao.consumer.CartaoTransacaoConsumer;
import br.com.cartao.transacao.domain.request.CartaoIntegracaoRequest;
import br.com.cartao.transacao.domain.request.CartaoTransacaoRequest;
import br.com.cartao.transacao.domain.response.CartaoIntegracaoResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cartoes")
public class HabilitaTransacaoCartaoResource {

    private static Logger logger = LoggerFactory.getLogger(HabilitaTransacaoCartaoResource.class);

    private final CartaoTransacaoConsumer cartaoTransacaoConsumer;

    public HabilitaTransacaoCartaoResource(CartaoTransacaoConsumer cartaoTransacaoConsumer) {
        this.cartaoTransacaoConsumer = cartaoTransacaoConsumer;
    }

    @PostMapping
    public ResponseEntity<?> habilitaTransacaoCartao(@RequestBody @Valid CartaoTransacaoRequest cartaoTransacaoRequest){
        logger.info("Requisição para habilitar as transações do cartao enviadas pelo kafka recebida. Email: {}", cartaoTransacaoRequest.getEmail());

        CartaoIntegracaoRequest cartaoIntegracaoRequest = cartaoTransacaoRequest.toIntegracao();

        CartaoIntegracaoResponseDto cartaoIntegracaoResponseDto = cartaoTransacaoConsumer.criaTransacaoCartao(cartaoIntegracaoRequest);

        logger.info("Transacao do cartão habilitada. ");

        return ResponseEntity.ok().build();
    }
}
