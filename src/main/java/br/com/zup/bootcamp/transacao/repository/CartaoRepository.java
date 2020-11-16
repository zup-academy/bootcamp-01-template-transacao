package br.com.zup.bootcamp.transacao.repository;

import br.com.zup.bootcamp.transacao.model.Cartao;
import br.com.zup.bootcamp.transacao.model.Transacao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository extends PagingAndSortingRepository<Cartao, UUID> {

    Collection<Cartao> findById(String id);
}
