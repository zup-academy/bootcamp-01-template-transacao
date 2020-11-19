package dev.arielalvesdutra.transacao.controllers;

import dev.arielalvesdutra.transacao.controllers.dtos.TransacaoResponseDTO;
import dev.arielalvesdutra.transacao.entities.Transacao;
import dev.arielalvesdutra.transacao.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cartoes")
@RestController
public class CartaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/{cartaoId}/transacoes")
    public ResponseEntity<Page<TransacaoResponseDTO>> buscaTransacoes(
            @PathVariable String cartaoId,
            @PageableDefault(size = 10) Pageable paginacao) {
        Page<Transacao> transacoes = transacaoService.buscaTodasPeloCartaoId(cartaoId, paginacao);

        return ResponseEntity.ok().body(TransacaoResponseDTO.toDTO(transacoes));
    }
}
