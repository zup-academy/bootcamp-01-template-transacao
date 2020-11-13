package br.com.itau.transacao.controller;

import br.com.itau.transacao.model.Compra;
import br.com.itau.transacao.model.CompraResponse;
import br.com.itau.transacao.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cartoes")
public class CompraController {

    private final CompraService compraService; //1

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/{id}/compras")
    public ResponseEntity<List<CompraResponse>> exibeCompras(@PathVariable("id") @Valid @NotBlank String id) { //1
        List<Compra> compras = compraService.buscaCompras(id); //1

        if (compras == null) { //1
            return ResponseEntity.notFound().build();
        }

        List<CompraResponse> listaDeComprasResponse = new ArrayList<>(); //1
        compras.forEach(compra -> { //1
            CompraResponse compraResponse = new CompraResponse(compra);
            listaDeComprasResponse.add(compraResponse);
        });

        return ResponseEntity.ok(listaDeComprasResponse);
    }
}
