package br.com.zup.transacao.api.controller;

import br.com.zup.transacao.domain.entity.Transacao;
import br.com.zup.transacao.domain.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    private final Pageable paginaComLimiteElementos = PageRequest.of(0, 10, Sort.by("efetivadaEm").descending());

    private final Logger log = LoggerFactory.getLogger(TransacaoController.class);

    @GetMapping("transacoes/{idCartao}")
    public ResponseEntity<?> consultarTransacoesDoCartao(@PathVariable UUID idCartao) {

        Page<Transacao> transacoes = repository.findAll(paginaComLimiteElementos);

        if (transacoes.isEmpty()) {
            log.warn("Nenhuma transação encontrada para o cartão {}", idCartao);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transacoes.get().map(Transacao::toDto));
    }
}
