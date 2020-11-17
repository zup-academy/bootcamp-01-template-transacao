package br.com.transacao.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.transacao.model.Transacao;

//Contagem de Pontos - TOTAL:1
//1 - Transacao

@Repository
public interface TransacaoRepository  extends CrudRepository<Transacao, Long>{

	@Query(nativeQuery = true, value="select * from Transacao c where c.id_cartao = :idcartao order by c.instante desc limit 10")
	List<Transacao> buscarUltimasTransacaos(@Param("idcartao") String idCartao);
	
	List<Transacao> findByInstante(String id_cartao, Pageable pageable);
	
	List<Transacao> findByIdCartao(String idCartao);
}
