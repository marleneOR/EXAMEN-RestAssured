package com.nttdata.glue;

import com.nttdata.steps.CrearOrdenStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearOrdenStepDef {
    @Steps
    CrearOrdenStep crearOrdenStep;
    @Given("tengo el URL del API de la tienda PetStore")
    public void tengoElURLDelAPIDeLaTiendaPetStore() {
    }

    @When("creo una orden con id {int}, petId {int}, quantity {int}, shipDate {string} y status {string}")
    public void creoUnaOrdenConIdPetIdQuantityShipDateStatusYStatusStatus(int id, int petId, int quantity, String shipDate, String status) {
        crearOrdenStep.crearOrden(id,petId,quantity,shipDate,status);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        crearOrdenStep.validarCodigoRespuesta(statusCode);
    }

    @And("el cuerpo de la respuesta contiene el id y status no nulos")
    public void elCuerpoDeLaRespuestaContieneElIdYStatusNoNulos() {
       crearOrdenStep.validarCamposNoNulos();
    }


}
