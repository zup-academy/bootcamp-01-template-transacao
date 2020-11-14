package com.marcoscoutozup.transacao.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JwtUtilsTests {

    @Test
    @DisplayName("Não deve retornar email se token for nulo")
    public void naoDeveRetornarEmailSeTokenForNulo(){
        assertThrows(IllegalArgumentException.class,
                () -> JwtUtils.retornarEmailDoToken(null));
    }
}
