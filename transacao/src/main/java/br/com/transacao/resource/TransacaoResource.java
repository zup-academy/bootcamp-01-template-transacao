package br.com.transacao.resource;
import br.com.transacao.dtos.TransacaoDto;
import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.CartaoRepository;
import br.com.transacao.repositories.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/api/transacoes")
public class TransacaoResource {


    private final TransacaoRepository transacaoRepository;

    private final CartaoRepository cartaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);


    public TransacaoResource(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }


    @GetMapping("/{cartaoId}")
    public ResponseEntity<?> busca(@PathVariable String cartaoId){

        var cartao = cartaoRepository.findById(cartaoId);

        var transacoesDtos = cartao.get().retornarTransacoes();

        logger.info("As dez últimas transações de {} foram solicitadas e exibidas ao proprietário do cartão.",
                cartao.get().getEmail());

        return ResponseEntity.ok(transacoesDtos);

    }
}
