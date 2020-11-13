package br.com.itau.transacao.service;

import br.com.itau.transacao.client.CartaoClient;
import br.com.itau.transacao.exception.ApiErrorException;
import br.com.itau.transacao.model.CadastroCartao;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    private final Logger logger = LoggerFactory.getLogger(CartaoService.class);
//1
    private final CartaoClient cartaoClient;

    public CartaoService(CartaoClient cartaoClient) {
        this.cartaoClient = cartaoClient;
    }

    public void cadastra(CadastroCartao cadastroCartao) { //1
        try { //1
            cartaoClient.notificaCadastroCartao(cadastroCartao);
        } catch (FeignException feignException){ //1
            logger.error("Falha ao cadastrar cartão com final {}.", cadastroCartao.getId().substring(24));
            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível cadastrar o cartão."); //1
        }
    }

    public void exclui(String numeroCartao) {
        try { //1
            cartaoClient.notificaExcluirCartao(numeroCartao);
        } catch (FeignException feignException) { //1
            logger.error("Falha ao excluir cartão com final {}.", numeroCartao.substring(24));
            throw new ApiErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível excluir o cartão.");
        }
    }
}
