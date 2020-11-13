package br.com.cartao.transacao.consumer;

import br.com.cartao.transacao.domain.request.CartaoIntegracaoRequest;
import br.com.cartao.transacao.domain.response.CartaoIntegracaoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cartao", url = "${feign.url-transacao}")
public interface CartaoTransacaoConsumer {

    @RequestMapping(method = RequestMethod.POST, path = "/api/cartoes")
    public CartaoIntegracaoResponseDto criaTransacaoCartao(@RequestBody CartaoIntegracaoRequest cartaoIntegracaoRequest);

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/cartoes/{id}")
    public void removeTransacaoCartao(@PathVariable("id") String idCartao);
}
