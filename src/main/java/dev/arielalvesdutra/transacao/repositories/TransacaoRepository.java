package dev.arielalvesdutra.transacao.repositories;

import dev.arielalvesdutra.transacao.entities.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, String> {

    /**
     * Busca todas as transações pelo ID do cartão.
     *
     * @param cartaoId ID do cartão no Serviço de Propostas.
     * @param paginacao
     *  
     * @return
     */
    Page<Transacao> findAllByCartaoId(String cartaoId, Pageable paginacao);
}
