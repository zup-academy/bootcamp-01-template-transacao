package br.com.cartao.transacao.resource;

import br.com.cartao.transacao.domain.model.Cartao;
import br.com.cartao.transacao.domain.response.TransacaoCartaoResponseDto;
import br.com.cartao.transacao.service.ConsultaTransacaoService;
import br.com.cartao.transacao.service.VerificaCartaoValido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 5
 */

@RestController
@RequestMapping("/v1/transacoes")
public class ConsultaComprasRecentesResource {

    private static Logger logger = LoggerFactory.getLogger(ConsultaComprasRecentesResource.class);
    // +1
    private final ConsultaTransacaoService consultaTransacaoService;

    private final EntityManager manager;
    // +1
    private final VerificaCartaoValido verificaCartaoValido;

    public ConsultaComprasRecentesResource(ConsultaTransacaoService consultaTransacaoService, EntityManager manager, VerificaCartaoValido verificaCartaoValido) {
        this.consultaTransacaoService = consultaTransacaoService;
        this.manager = manager;
        this.verificaCartaoValido = verificaCartaoValido;
    }

    @GetMapping("/{id}/compras-recentes")
    public ResponseEntity<?> consultasComprasRecentes(@PathVariable(value = "id",required = true) String idCartao){
        logger.info("Requisição para consultar ultimas compras recebida.");

        // +1
        Optional<Cartao> cartaoBuscado = Optional.ofNullable(manager.find(Cartao.class, idCartao));

        // +1
        if (cartaoBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cartão não encontrado");
        }
        // +1
        List<TransacaoCartaoResponseDto> transacaoCartaoResponseDtos = consultaTransacaoService.consulta(cartaoBuscado.get().getNumeroCartao());

        return ResponseEntity.ok().body(transacaoCartaoResponseDtos);
    }
}
