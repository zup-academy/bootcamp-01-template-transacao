package br.com.transacao.services;

import br.com.transacao.dtos.TransacaoDto;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class BuscarDezUltimasTransacoes {


    public Set<TransacaoDto> gerarLista(Set<TransacaoDto> transacoes){

        List<TransacaoDto> transacoesSorted = new ArrayList<>(transacoes);

        transacoesSorted.sort(Comparator.comparing(TransacaoDto::getEfetivadaEm));

        return new HashSet<>(transacoesSorted
                .subList(transacoesSorted.size() - 10, transacoesSorted.size()));

    }
}
