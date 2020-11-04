package br.com.transacao.repositories;

import br.com.transacao.entidades.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, String> {
}
