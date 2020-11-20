package br.com.zup.transacao.controller;

import br.com.zup.transacao.model.InfoTransacaoCartao;
import br.com.zup.transacao.response.InfoTransacaoCartaoResponse;
import br.com.zup.transacao.service.InfoTransacaoCartaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacoes")
public class ConsultarCartaoController {

    private Logger logger = LoggerFactory.getLogger(ConsultarCartaoController.class);
    private EntityManager entityManager;
    private InfoTransacaoCartaoService cartaoService; //1

    public ConsultarCartaoController(EntityManager entityManager, InfoTransacaoCartaoService cartaoService) {
        this.entityManager = entityManager;
        this.cartaoService = cartaoService;
    }

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<List<InfoTransacaoCartaoResponse>>
    consultarTransacaoCartaoPorId(@PathVariable("id") UUID numeroCartao, @AuthenticationPrincipal Jwt jwt) {

        //ver se o usuario esta autenticado
        Optional<String> emailAutenticado =Optional.ofNullable(jwt.getClaim("email"));
        Assert.isTrue(emailAutenticado.isPresent(), "Para fazer um aviso de viagem, " +
                "deve-se estar logado com um email autorizado");

        List<InfoTransacaoCartao> transacoes =
                cartaoService.listarTransacoes(entityManager,
                        numeroCartao, emailAutenticado.get()); //2

        if (transacoes.isEmpty()) //3
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        logger.info("lista de transações com dados? {}", transacoes.isEmpty());

        List<InfoTransacaoCartaoResponse> responses =
                cartaoService.toListaInfoTransacaoCartaoResponse(transacoes); //4

        logger.info("transacoes realizadas: {}", responses.toString());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
