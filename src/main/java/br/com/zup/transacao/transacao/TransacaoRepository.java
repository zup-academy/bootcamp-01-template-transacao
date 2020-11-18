package br.com.zup.transacao.transacao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String> {
    public List<Transacao> findByCartaoIdCartao(String idCartao);
}
