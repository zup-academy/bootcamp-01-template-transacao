package br.com.cartao.transacao.service;

import br.com.cartao.transacao.domain.response.TransacaoCartaoResponseDto;
import br.com.cartao.transacao.repository.TransacaoCartaoRepository;
import br.com.cartao.transacao.utils.Encoder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Carga intrínseca máxima permitida - 7
 * Carga intrínseca da classe - 6
 */

@Service
public class ConsultaTransacaoService {

    // +1
    private final TransacaoCartaoRepository transacaoCartaoRepository;

    public ConsultaTransacaoService(TransacaoCartaoRepository transacaoCartaoRepository) {
        this.transacaoCartaoRepository = transacaoCartaoRepository;
    }
    // +1
    public List<TransacaoCartaoResponseDto> consulta(String idCartao){

        List<TransacaoCartaoResponseDto> transacaoCartaoResponseDtos;

        List<TransacaoCartaoResponseDto> todasTransacoesDoCartao = transacaoCartaoRepository.findAll(Sort.by("efetivadaEm").descending()).stream()
                // +1
                .filter(transacaoCartao ->
                        idCartao.equals(Encoder.decode(transacaoCartao.getIdCartao()))
                )
                // +1
                .map(transacaoCartao -> {
                    return new TransacaoCartaoResponseDto(transacaoCartao);
                })
                //+1
                .collect(Collectors.toList());
        transacaoCartaoResponseDtos = todasTransacoesDoCartao.subList(0, todasTransacoesDoCartao.size());
        // +1
        if (todasTransacoesDoCartao.size()>10){
            transacaoCartaoResponseDtos = todasTransacoesDoCartao.subList(0, 10);
        }

        return transacaoCartaoResponseDtos;
    }
}
