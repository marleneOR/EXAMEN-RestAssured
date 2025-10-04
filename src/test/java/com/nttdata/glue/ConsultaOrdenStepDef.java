package com.nttdata.glue;

import com.nttdata.steps.ConsultaOrdenStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultaOrdenStepDef {
    @Steps
    ConsultaOrdenStep consultaOrdenStep;
    @Given("estoy en la pagina de PetStore")
    public void estoyEnLaPaginaDePetStore() {
    }

    @When("hago consulta de la orden por id {int}")
    public void hagoConsultaDeLaOrdenPorIdIdOrden(int idOrden) {
        consultaOrdenStep.consultarOrden(idOrden);
    }

    @Then("el codigo de respuesta del orden es {int}")
    public void elCodigoDeRespuestaDelOrdenEsStatusCode(int statusCode) {
        consultaOrdenStep.validarcodigoRespuesta(statusCode);
    }
}
