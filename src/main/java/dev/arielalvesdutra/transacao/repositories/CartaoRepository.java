package dev.arielalvesdutra.transacao.repositories;

import dev.arielalvesdutra.transacao.entities.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, String> {
}
