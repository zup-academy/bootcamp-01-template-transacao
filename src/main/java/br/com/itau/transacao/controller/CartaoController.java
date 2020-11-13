package br.com.itau.transacao.controller;

import br.com.itau.transacao.model.CadastroCartao;
import br.com.itau.transacao.model.CadastroCartaoRequest;
import br.com.itau.transacao.service.CartaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/v1/cartoes")
public class CartaoController {

    private final Logger logger = LoggerFactory.getLogger(CartaoController.class);
//1
    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping("/{id}/cadastro")
    public ResponseEntity<?> cadastraCartao(@PathVariable("id") String id, @Valid @RequestBody CadastroCartaoRequest cadastroCartaoRequest) { //1
        CadastroCartao cadastroCartao = new CadastroCartao(id, cadastroCartaoRequest.getEmail()); //1

        cartaoService.cadastra(cadastroCartao);
        logger.info("Cadastro do cartão com final {} foi criado com sucesso!", cadastroCartao.getId().substring(24));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/deleta")
    public ResponseEntity<?> deletaCartao(@PathVariable("id") @Valid @NotBlank String numeroCartao) {
        cartaoService.exclui(numeroCartao);
        logger.info("Exclusão do cartão com final {} foi criado com sucesso!", numeroCartao.substring(24));

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
