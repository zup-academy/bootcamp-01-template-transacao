package dev.arielalvesdutra.transacao.http_clients;

import dev.arielalvesdutra.transacao.http_clients.dtos.ResultadoCartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "propostas", url = "${propostas.url}")
public interface PropostaHttpClient {

    /**
     * Busca cartão no Serviço de Propostas.
     *
     * @param legadoId ID do Cartão no Sistema Legado
     * @return
     */
    @GetMapping("/api/propostas")
    ResultadoCartaoDTO buscaCartaoPeloLegadoId(
            @RequestParam String legadoId);
}
