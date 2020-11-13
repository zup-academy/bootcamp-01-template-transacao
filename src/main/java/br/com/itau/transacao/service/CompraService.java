package br.com.itau.transacao.service;

import br.com.itau.transacao.model.Cartao;
import br.com.itau.transacao.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    private final Logger logger = LoggerFactory.getLogger(CompraService.class);

    private final EntityManager entityManager;

    public CompraService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Compra> buscaCompras(String numeroCartao) { //1
        Query buscaComprasParaAqueleCartao = entityManager.createQuery("select u from Cartao u where u.numeroCartao =: value");
        buscaComprasParaAqueleCartao.setParameter("value", numeroCartao);

        if (buscaComprasParaAqueleCartao.getResultList().isEmpty()) {
            logger.error("Cartão não foi encontrado.");
            return null;
        }

        List<Cartao> listaDeCartoes = buscaComprasParaAqueleCartao.getResultList(); //1
        logger.info("Compras encontradas para o cartão com final {}", numeroCartao);

        List<Cartao> listaDeCartoesComFiltro = new ArrayList<>();
        for (int i = listaDeCartoes.size(); i > (listaDeCartoes.size() - 10); i--) { //1
            listaDeCartoesComFiltro.add(listaDeCartoes.get(i-1));
        }
        logger.info("{} primeiras compras filtradas para o cartão com final {}", listaDeCartoesComFiltro.size(), numeroCartao);

        List<Compra> listaDeCompras = new ArrayList<>();

        listaDeCartoesComFiltro.forEach(cartao -> { //1
            Query buscaComposicaoDasCompras = entityManager.createQuery("select u from Compra u where u.cartao =: value");
            buscaComposicaoDasCompras.setParameter("value", cartao);

            listaDeCompras.add((Compra) buscaComposicaoDasCompras.getResultList().get(0));
        });

        logger.info("{} composições de compras encontradas para o cartão com final {}", listaDeCompras.size(), numeroCartao);
        return listaDeCompras;
    }
}
