package br.com.zup.transacao.controller;
import br.com.zup.transacao.utils.Error;
import br.com.zup.transacao.dto.response.TransacaoResponse;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    private final int quantidadeDeResultados;

    public TransacaoController(TransacaoRepository transacaoRepository,  @Value("${resultados.quantidade.maxima}") int quantidadeDeResultados) {
        this.transacaoRepository = transacaoRepository;
        this.quantidadeDeResultados = quantidadeDeResultados;
    }

    @GetMapping("/{cartaoID}")
    public ResponseEntity<?> consultarTransacoesDoCartao(@PathVariable String cartaoID){

        Pageable pageable = PageRequest.of(0, quantidadeDeResultados, Sort.by("efetivadaEm").descending());
        List<Transacao> transacoes = transacaoRepository.findAllByCartaoId(cartaoID, pageable);

        if (transacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(Arrays.asList("Transacao não encontrada")));
        }

        List<TransacaoResponse> transacaoResponse = transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(transacaoResponse);
    }
}
