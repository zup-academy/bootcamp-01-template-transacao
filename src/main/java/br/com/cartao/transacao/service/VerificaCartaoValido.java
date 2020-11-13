package br.com.cartao.transacao.service;

import br.com.cartao.transacao.consumer.CartaoValidoConsumer;
import br.com.cartao.transacao.domain.response.CartaoResponseSistemaLegado;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 4
 */

@Service
public class VerificaCartaoValido {

    private static Logger logger = LoggerFactory.getLogger(VerificaCartaoValido.class);
    // +1
    private final CartaoValidoConsumer cartaoValidoConsumer;

    public VerificaCartaoValido(CartaoValidoConsumer cartaoValidoConsumer) {
        this.cartaoValidoConsumer = cartaoValidoConsumer;
    }
    // +1
    public Optional<CartaoResponseSistemaLegado> verfica(String idCartao){
        logger.info("Iniciando a validação do cartão");
        // +1
        try{
            CartaoResponseSistemaLegado cartaoResponseSistemaLegado = cartaoValidoConsumer.verificaCartaoValido(idCartao);
            logger.info("Cartão validado com sucesso.");
            return Optional.ofNullable(cartaoResponseSistemaLegado);

        }
        // +1
        catch (FeignException e){
            logger.warn("Cartão não existe ou erro na validação do cartão. ");
            return Optional.empty();
        }

    }
}
