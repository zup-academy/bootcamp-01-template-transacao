package br.com.itau.transacao.client;

import br.com.itau.transacao.model.CadastroCartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "${endereco.api.cartao}", name = "cartao")
public interface CartaoClient {

    @PostMapping("/api/cartoes")
    ResponseEntity<?> notificaCadastroCartao(@Valid @RequestBody CadastroCartao cadastroCartao);

    @DeleteMapping("/api/cartoes/{id}")
    ResponseEntity<?> notificaExcluirCartao(@Valid @PathVariable("id") String numeroCartao);
}
