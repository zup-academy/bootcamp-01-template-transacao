package br.com.cartao.transacao.repository;

import br.com.cartao.transacao.domain.model.TransacaoCartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoCartaoRepository extends CrudRepository<TransacaoCartao, String> {
}
