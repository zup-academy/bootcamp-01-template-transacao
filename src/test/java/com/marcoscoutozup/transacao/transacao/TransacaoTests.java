package com.marcoscoutozup.transacao.transacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransacaoTests {

    @Test
    @DisplayName("Não deve transformar em lista de response uma lista nula")
    public void naoDeveTransformarEmListaDeResponseUmaListaNula(){
        assertThrows(IllegalArgumentException.class,
                () -> Transacao.toResponseList(null));
    }

    @Test
    @DisplayName("Não deve verificar email se token for nulo")
    public void naoDeveVerificarEmailSeTokenForNulo(){
        assertThrows(IllegalArgumentException.class,
                () -> new Transacao().verificarSeEmailDoTokenEIgualAoEmailDaTransacao(null));
    }

}
