package br.com.transacao.repositories;

import br.com.transacao.entidades.Transacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String> {
}
