package br.com.zup.bootcamp.transacao.repository;

import br.com.zup.bootcamp.transacao.model.Transacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository  extends PagingAndSortingRepository<Transacao, UUID> {

    List<Transacao> findAllByCartaoId(String idCartao, Pageable pageRequest);
}
