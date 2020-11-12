package br.com.cartao.transacao.repository;

import br.com.cartao.transacao.domain.model.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, String> {

    List<Cartao> findAll();
}
