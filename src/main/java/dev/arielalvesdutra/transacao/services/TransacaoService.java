package dev.arielalvesdutra.transacao.services;

import dev.arielalvesdutra.transacao.configs.dtos.TransacaoMessageCartaoDTO;
import dev.arielalvesdutra.transacao.configs.dtos.TransacaoMessageDTO;
import dev.arielalvesdutra.transacao.entities.Cartao;
import dev.arielalvesdutra.transacao.entities.Transacao;
import dev.arielalvesdutra.transacao.http_clients.PropostaHttpClient;
import dev.arielalvesdutra.transacao.http_clients.dtos.ResultadoCartaoDTO;
import dev.arielalvesdutra.transacao.repositories.TransacaoRepository;
import dev.arielalvesdutra.transacao.services.dtos.BuscaOuCadastraCartaoDTO;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class TransacaoService {

    private final Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    @Autowired
    private final TransacaoRepository transacaoRepository;

    @Autowired
    private final CartaoService cartaoService;

    @Autowired
    private final PropostaHttpClient propostaHttpClient;

    public TransacaoService(
            TransacaoRepository transacaoRepository,
            CartaoService cartaoService,
            PropostaHttpClient propostaHttpClient) {

        this.transacaoRepository = transacaoRepository;
        this.cartaoService = cartaoService;
        this.propostaHttpClient = propostaHttpClient;
    }

    public Page<Transacao> buscaTodasPeloCartaoId(String cartaoId, Pageable paginacao) {
        Cartao cartao = cartaoService.buscaPeloId(cartaoId);

        return transacaoRepository.findAllByCartaoId(cartao.getId(), paginacao);
    }

    @Transactional
    public Transacao cadastrar(TransacaoMessageDTO dto) {
        TransacaoMessageCartaoDTO messageCartaoDTO = dto.getCartao();
        logger.info("Buscando cartão de ID legado {} no Serviço de Propostas.", messageCartaoDTO.getId());

        try {

            ResultadoCartaoDTO resultadoDTO = propostaHttpClient.buscaCartaoPeloLegadoId(messageCartaoDTO.getId());
            logger.info("Buscando ou cadastrando cartão de ID legado {}.", resultadoDTO.getLegadoId());
            Cartao cartao = cartaoService.buscaOuCadastra(new BuscaOuCadastraCartaoDTO(resultadoDTO, messageCartaoDTO.getEmail()));

            Transacao transacaoParaSalvar = dto
                    .paraEntidade()
                    .setCartao(cartao);

            logger.info("Cadastrando transação de ID legado {}.", transacaoParaSalvar.getLegadoId());
            Transacao transacaoSalva = transacaoRepository.save(transacaoParaSalvar);
            logger.info("Cadastrada transação de ID {} para o cartão de ID  legado {}.", transacaoSalva.getId(), cartao.getLegadoId());

            return transacaoSalva;
        } catch (FeignException e) {
            throw new ResponseStatusException(
                    INTERNAL_SERVER_ERROR,
                    "Ocorreu um erro buscar o cartão de ID legado " + dto.getId() + "!");
        }
    }
}
