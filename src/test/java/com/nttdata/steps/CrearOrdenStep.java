package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;


import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CrearOrdenStep{

    private static String URL =  "https://petstore.swagger.io/v2/store/order";
    Response response;
    public void crearOrden(int id, int petId, int quantity, String shipDate, String status){
        Serenity.setSessionVariable("id").to(id);
        Serenity.setSessionVariable("status").to(status);
        response = given()
                .contentType("application/json; charset=UTF-8")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \"true\"\n" +
                        "}"
                )
                .log()
                .all()
                .when()
                .post(URL );
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("El código de respuesta es: " + statusCode);
    }

    public void validarCamposNoNulos() {
        int idEsperado = Serenity.sessionVariableCalled("id");
        String statusEsperado = Serenity.sessionVariableCalled("status");

        restAssuredThat(response -> response.body("id", equalTo(idEsperado)));
        restAssuredThat(response -> response.body("status", equalTo(statusEsperado)));
        restAssuredThat(response -> response.body("id", notNullValue()));
        restAssuredThat(response -> response.body("status", notNullValue()));

        System.out.println("   - Id esperado es igual: " + idEsperado);
        System.out.println("   - Status es igual: " + statusEsperado);
        System.out.println("   - El body completo:");
        SerenityRest.lastResponse().prettyPrint();
    }
}
