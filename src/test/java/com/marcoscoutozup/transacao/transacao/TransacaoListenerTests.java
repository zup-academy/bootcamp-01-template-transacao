package com.marcoscoutozup.transacao.transacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;

public class TransacaoListenerTests {

    private TransacaoListener transacaoListener;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        transacaoListener = new TransacaoListener(entityManager);
    }

    @Test
    @DisplayName("Deve lanács excessão se resposta de mensageria for nula")
    public void deveLancarExcessaoSeRespostaDeMensageriaForNula(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> transacaoListener.ouvir(null));
    }
}
