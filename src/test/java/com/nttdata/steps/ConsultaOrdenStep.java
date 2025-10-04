package com.nttdata.steps;

import com.nttdata.model.Order;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsultaOrdenStep {
    private static String URL = "https://petstore.swagger.io/v2/";
    public Order order;
    public void consultarOrden(int idOrder){
        Response response = given()
                .baseUri(URL)
                .log()
                .all()
                .when()
                .get("store/order/" + idOrder);
        if (response.statusCode() == 200) {
            order = response.as(Order.class);
            litarOrden(order);
        } else if (response.statusCode() == 404) {
            String message = response.toString();
            System.out.println(message);
        }
    }
    public void litarOrden(Order order){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Id Orden: " + order.getId());
        System.out.println("PetId Orden: " + order.getPetId());
        System.out.println("Quantity Orden: " + order.getQuantity());
        System.out.println("ShipDate Orden: " + order.getShipDate());
        System.out.println("status Orden: "+ order.getStatus());
        System.out.println("complete Orden: " + order.isComplete());
        System.out.println((SerenityRest.lastResponse().print()));
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
    public void validarcodigoRespuesta(int statusCode){
        assertThat(lastResponse().statusCode(),is(statusCode));
    }

}
