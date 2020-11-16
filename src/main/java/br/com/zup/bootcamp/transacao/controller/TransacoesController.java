package br.com.zup.bootcamp.transacao.controller;

import br.com.zup.bootcamp.transacao.advice.ErroPadronizado;
import br.com.zup.bootcamp.transacao.advice.HandlerErro;
import br.com.zup.bootcamp.transacao.model.Transacao;
import br.com.zup.bootcamp.transacao.repository.TransacaoRepository;
import br.com.zup.bootcamp.transacao.response.TransacaoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api/transacoes")
public class TransacoesController {

    private final TransacaoRepository transacaoRepository;
    private final int quantidadeDeItens;
    private final Logger logger = LoggerFactory.getLogger(TransacoesController.class);

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

        if (!transacoes.get(0).verificarSeCartaoEIgualAoEmailToken()){
            logger.warn("[Consulta transações]: O usuário logado não tem permissão para consultar transações do cartao: {}", idCartao);
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ErroPadronizado(Collections.singletonList("Não foi possível consultar! Cartão não pertencente ao solicitante.")));
        }

        List<TransacaoResponse> transacaoResponse = transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok(transacaoResponse);
    }
}
