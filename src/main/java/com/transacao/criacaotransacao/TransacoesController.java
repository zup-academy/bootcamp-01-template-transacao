package com.transacao.criacaotransacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    @Autowired
    EntityManager manager;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> buscaTransacoes(@PathVariable String idCartao) {
        //1
        Cartao cartao = manager.find(Cartao.class, idCartao);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }

        //2
        List<Transacoes> lista = manager
                .createQuery("SELECT t from Cartao c JOIN Transacoes t on t.cartao.id=c.id " +
                        "WHERE id_cartao = :idCartao " +
                        "ORDER BY t.efetivadaEm DESC", Transacoes.class)
                .setParameter("idCartao", cartao.getIdCartao())
                .setMaxResults(10)
                .getResultList();

        return ResponseEntity.ok(lista);
    }
}
