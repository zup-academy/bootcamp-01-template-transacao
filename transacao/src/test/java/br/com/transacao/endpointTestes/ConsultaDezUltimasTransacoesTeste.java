package br.com.transacao.endpointTestes;

import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsultaDezUltimasTransacoesTeste {


    @LocalServerPort
    private int port;

    @Test
    public void deveriaRetornarOkConsultaTransacoes() throws JSONException {

        var numeroCartaoExistente = "5541da9c-79c5-44fb-b701-cc50ed07b45d";

        given()
                .basePath("/api/transacoes/" + numeroCartaoExistente)
                .header("Authorization", getToken())
                .port(port)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());

    }


    @Test
    public void deveriaRetornarNotFoundConsultaTransacoesCartaoNaoExistente() throws JSONException {

        var numeroCartaoNaoExistente = "5541da9c-79c5-44fb-b701-cc50ed07b412";

        given()
                .basePath("/api/transacoes/" + numeroCartaoNaoExistente)
                .header("Authorization", getToken())
                .port(port)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());

    }


    public String getToken() throws JSONException {

        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "password")
                .formParam("username", "bootcamp")
                .formParam("password", "bootcampproposta")
                .formParam("client_id", "nosso-cartao")
                .formParam("client_secret", "")
                .when()
                .post("http://localhost:18080/auth/realms/nosso-cartao/protocol/openid-connect/token");


        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();

        return "Bearer " + accessToken;

    }

}
