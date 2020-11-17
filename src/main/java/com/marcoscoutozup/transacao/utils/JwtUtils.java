package com.marcoscoutozup.transacao.utils;

import com.auth0.jwt.JWT;
import org.springframework.util.Assert;

public class JwtUtils {

    public static String retornarEmailDoToken(String token){
        Assert.notNull(token, "O token não pode ser nulo para capturar dados");
        return JWT.decode(token.substring(7))
                .getClaim("email")
                .asString();
    }

}
