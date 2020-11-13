package br.com.transacao.resource;

import br.com.transacao.entidades.Transacao;
import br.com.transacao.repositories.CartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transacoes")
public class TransacaoResource {

    /* pontos de dificuldade de entendimento -> 4 pontos */

    /* @complexidade - acoplamento contextual */
    private final CartaoRepository cartaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);


    public TransacaoResource(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }


    @GetMapping("/{cartaoId}")
    public ResponseEntity<?> busca(@PathVariable String cartaoId){

        /* @complexidade + @complexidade */
        var cartao = cartaoRepository.findById(cartaoId);
        if(cartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        /* @complexidade */
        var transacoesDtos = cartao.get().retornarTransacoes();

        logger.info("[BUSCA 10 ÚLTIMAS TRANSAÇÕES] As dez últimas transações de {} foram solicitadas e exibidas ao proprietário do cartão.",
                cartao.get().getEmail());

        return ResponseEntity.ok(transacoesDtos);

    }
}
