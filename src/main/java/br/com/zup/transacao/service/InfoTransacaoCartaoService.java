package br.com.zup.transacao.service;

import br.com.zup.transacao.model.InfoTransacaoCartao;
import br.com.zup.transacao.response.InfoTransacaoCartaoResponse;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InfoTransacaoCartaoService {

    public List<InfoTransacaoCartao> listarTransacoes(EntityManager entityManager,
                                                      UUID numeroCartao, String emailDonoCartao){ //1

        TypedQuery<InfoTransacaoCartao> typedQuery =
                entityManager.createQuery("select i from " +
                                "InfoTransacaoCartao i where i.cartao.id =:id " +
                                "and i.cartao.email =:email order by efetivadaEm desc",
                        InfoTransacaoCartao.class);
        typedQuery.setParameter("id", numeroCartao);
        typedQuery.setParameter("email", emailDonoCartao);
        typedQuery.setMaxResults(10);

        return typedQuery.getResultList();
    }

    public List<InfoTransacaoCartaoResponse> toListaInfoTransacaoCartaoResponse(List<InfoTransacaoCartao> transacoes){ //2

        List<InfoTransacaoCartaoResponse> responseList = new ArrayList<>();
        for (InfoTransacaoCartao transacaoCartao : transacoes){ //3
            InfoTransacaoCartaoResponse response =
                    transacaoCartao.toInfoTransacaoCartaoResponse();
            responseList.add(response);
        }

        return responseList;
    }

}
