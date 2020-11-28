package br.com.cartao.transacao.consumer;

import br.com.cartao.transacao.domain.response.CartaoResponseSistemaLegado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cartaoConfirma", url = "${feign.url-cartao}")
public interface CartaoValidoConsumer {

    @RequestMapping(method = RequestMethod.GET, path = "/api/cartoes/{id}")
    public CartaoResponseSistemaLegado verificaCartaoValido(@PathVariable(value = "id",required = true) String idCartao);
}
