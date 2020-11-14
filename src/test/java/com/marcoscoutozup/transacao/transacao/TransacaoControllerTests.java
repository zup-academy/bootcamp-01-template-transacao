package com.marcoscoutozup.transacao.transacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class TransacaoControllerTests {

    private TransacaoController controller;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery query;

    @Mock
    private Transacao transacao;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        controller = new TransacaoController(entityManager, 10);
    }

    @Test
    @DisplayName("Não deve retornar resultado se nenhuma transação foi encontrada para o cartão")
    public void naoDeveRetornarResultadoSeNenhumaTransacaoFoiEncontradaParaOCartao(){
       when(entityManager.createNamedQuery(anyString(), any())).thenReturn(query);
       when(query.setParameter(anyString(), any())).thenReturn(query);
       when(query.setMaxResults(anyInt())).thenReturn(query);
       when(query.getResultList()).thenReturn(new ArrayList());
       ResponseEntity responseEntity = controller.consultarTransacoesDoCartao(UUID.randomUUID(), new String());
       Assertions.assertTrue(responseEntity.getStatusCode().is4xxClientError());
       Assertions.assertTrue(responseEntity.getBody() instanceof Map);
    }

    @Test
    @DisplayName("Não deve retornar resultado se email do token não for o mesmo do proprietário do cartão")
    public void naoDeveRetornarResultadoSeEmailDoTokenNaoForOMesmoDoProprietarioDoCartao(){
       when(entityManager.createNamedQuery(anyString(), any())).thenReturn(query);
       when(query.setParameter(anyString(), any())).thenReturn(query);
       when(query.setMaxResults(anyInt())).thenReturn(query);
       when(query.getResultList()).thenReturn(List.of(transacao));
       when(transacao.verificarSeEmailDoTokenEIgualAoEmailDaTransacao(anyString())).thenReturn(false);
       ResponseEntity responseEntity = controller.consultarTransacoesDoCartao(UUID.randomUUID(), new String());
       Assertions.assertTrue(responseEntity.getStatusCode().is4xxClientError());
       Assertions.assertTrue(responseEntity.getBody() instanceof Map);
    }

    @Test
    @DisplayName("Deve retornar as transações encontradas do cartão")
    public void deveRetornarAsTransacoesEncontradasDoCartao(){
       when(entityManager.createNamedQuery(anyString(), any())).thenReturn(query);
       when(query.setParameter(anyString(), any())).thenReturn(query);
       when(query.setMaxResults(anyInt())).thenReturn(query);
       when(query.getResultList()).thenReturn(List.of(transacao));
       when(transacao.verificarSeEmailDoTokenEIgualAoEmailDaTransacao(anyString())).thenReturn(true);
       ResponseEntity responseEntity = controller.consultarTransacoesDoCartao(UUID.randomUUID(), new String());
       Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
       Assertions.assertTrue(responseEntity.getBody() instanceof List);
    }

}
