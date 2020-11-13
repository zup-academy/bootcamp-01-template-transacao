package br.com.cartao.transacao.resource;

import br.com.cartao.transacao.consumer.CartaoTransacaoConsumer;
import br.com.cartao.transacao.domain.request.CartaoIntegracaoRequest;
import br.com.cartao.transacao.domain.request.CartaoTransacaoRequest;
import br.com.cartao.transacao.domain.response.CartaoIntegracaoResponseDto;
import br.com.cartao.transacao.domain.response.CartaoResponseSistemaLegado;
import br.com.cartao.transacao.service.VerificaCartaoValido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 7
 */

@RestController
@RequestMapping("/v1/transacoes")
public class HabilitaTransacaoCartaoResource {

    private static Logger logger = LoggerFactory.getLogger(HabilitaTransacaoCartaoResource.class);
    // +1
    private final CartaoTransacaoConsumer cartaoTransacaoConsumer;
    // +1
    private final VerificaCartaoValido verificaCartaoValido;

    public HabilitaTransacaoCartaoResource(CartaoTransacaoConsumer cartaoTransacaoConsumer, VerificaCartaoValido verificaCartaoValido) {
        this.cartaoTransacaoConsumer = cartaoTransacaoConsumer;
        this.verificaCartaoValido = verificaCartaoValido;
    }

    @PostMapping("/habilita")
    // +1
    public ResponseEntity<?> habilitaTransacaoCartao(@RequestBody @Valid CartaoTransacaoRequest cartaoTransacaoRequest){
        logger.info("Requisição para habilitar as transações do cartao enviadas pelo kafka recebida. Email: {}", cartaoTransacaoRequest.getEmail());
        // +1
        Optional<?> cartaoVerificado = verificaCartaoValido.verfica(cartaoTransacaoRequest.getIdCartao());
        // +1
        if (cartaoVerificado.isEmpty()){
            logger.warn("Cartão não existe no banco de dados, id: {}",cartaoTransacaoRequest.getIdCartao());
            return ResponseEntity.badRequest().body("Cartão não encontrado!!");
        }
        // +1
        CartaoIntegracaoRequest cartaoIntegracaoRequest = cartaoTransacaoRequest.toIntegracao();
        // +1
        CartaoIntegracaoResponseDto cartaoIntegracaoResponseDto = cartaoTransacaoConsumer.criaTransacaoCartao(cartaoIntegracaoRequest);

        logger.info("Transacao do cartão habilitada. ");

        return ResponseEntity.ok().build();
    }
}
