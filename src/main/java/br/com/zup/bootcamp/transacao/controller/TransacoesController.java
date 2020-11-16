package br.com.zup.bootcamp.transacao.controller;

import br.com.zup.bootcamp.transacao.model.Transacao;
import br.com.zup.bootcamp.transacao.repository.TransacaoRepository;
import br.com.zup.bootcamp.transacao.response.TransacaoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api/transacoes")
public class TransacoesController {

    private final TransacaoRepository transacaoRepository;
    private final int quantidadeDeItens;

    public TransacoesController(TransacaoRepository transacaoRepository,
                                @Value("${consulta-paginada.quantidade-maxima}") int quantidadeDeItens) {
        this.transacaoRepository = transacaoRepository;
        this.quantidadeDeItens = quantidadeDeItens;
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> buscarCompras(@PathVariable String idCartao) {

        Pageable pageable = PageRequest.of(0, quantidadeDeItens, Sort.by("efetivadaEm").descending());
        List<Transacao> transacoes = transacaoRepository.findAllByCartaoId(idCartao, pageable);

        if (transacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TransacaoResponse> transacaoResponse = transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(transacaoResponse);
    }
}
