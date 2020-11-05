package br.com.transacao.services;

import br.com.transacao.dtos.TransacaoDto;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class BuscarDezUltimasTransacoes {


    public List<TransacaoDto> gerarLista(Set<TransacaoDto> transacoes){


        List<TransacaoDto> transacoesSorted = new ArrayList<>(transacoes);

        transacoesSorted.sort(Comparator.comparing(TransacaoDto::getEfetivadaEm));

        Collections.reverse(transacoesSorted);

        return transacoesSorted.subList(0,10);


    }
}
