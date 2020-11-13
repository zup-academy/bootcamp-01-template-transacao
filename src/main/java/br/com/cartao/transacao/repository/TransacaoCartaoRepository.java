package br.com.cartao.transacao.repository;

import br.com.cartao.transacao.domain.model.TransacaoCartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoCartaoRepository extends PagingAndSortingRepository<TransacaoCartao, String> {

    Page<TransacaoCartao> findAllById(String idTransacao, Pageable pageable);

    List<TransacaoCartao> findAll(Sort sort);
}
