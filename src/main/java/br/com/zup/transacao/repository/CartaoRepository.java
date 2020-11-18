package br.com.zup.transacao.repository;

import br.com.zup.transacao.model.Cartao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.UUID;

public interface CartaoRepository extends PagingAndSortingRepository<Cartao, UUID> {

    Collection<Cartao> findById(String id);
}
