package com.marcoscoutozup.transacao.transacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransacaoTests {

    @Test
    @DisplayName("Não deve transformar em lista de response uma lista nula")
    public void naoDeveTransformarEmListaDeResponseUmaListaNula(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Transacao.toResponseList(null));
    }

}
