package dev.arielalvesdutra.transacao.services;

import dev.arielalvesdutra.transacao.entities.Cartao;
import dev.arielalvesdutra.transacao.repositories.CartaoRepository;
import dev.arielalvesdutra.transacao.services.dtos.BuscaOuCadastraCartaoDTO;
import dev.arielalvesdutra.transacao.services.dtos.CadastrarCartaoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CartaoService {

    private final Logger logger = LoggerFactory.getLogger(CartaoService.class);

    @Autowired
    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    public Cartao buscaPeloId(String cartaoId) {
        return cartaoRepository.findById(cartaoId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cartão com ID "+ cartaoId + " não localizado!"));
    }

    /**
     * Busca cartão pelo ID ou cadastra um novo com o ID.
     *
     * Caso existe um cartão pelo, retorna o cartão.
     * Caso não exista um cartão registrado com o ID, cadastra um novo cartão no banco
     * de dados deste microservice e retorna o mesmo.
     *
     * @param dto DTO para auxiliar a busca ou cadastro de cartão.
     *
     * @return Cópia do Cartão salva neste microservice.
     */
    public Cartao buscaOuCadastra(BuscaOuCadastraCartaoDTO dto) {
        try {
            return buscaPeloId(dto.getId());
        } catch (EntityNotFoundException e) {
            return cadastrar(dto.paraCadastrarDTO());
        }
    }

    @Transactional
    public Cartao cadastrar(CadastrarCartaoDTO dto){
        return cartaoRepository.save(dto.paraEntidade());
    }
}
