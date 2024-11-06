package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByDateTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightDateSearchStepDefinition {
    Actor usuario = Actor.named("usuario");

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("el usuario se conecta al servicio")
    public void thatTheUserConnectToTheService() {
        usuario.attemptsTo(ConnectTo.theService());
    }
    @And("ingresa una fecha de inicio {string} y una fecha de fin {string}")
    public void thatTheUserWantsToSearchForAFlight(String fechaInicio, String fechaFin) {
        usuario.remember("fechaInicio", fechaInicio);
        usuario.remember("fechaFin", fechaFin);
    }

    @When("se realiza la busqueda de vuelos entre las fechas especificadas")
    public void heEntersTheDates() {
        String fechaInicio = usuario.recall("fechaInicio");
        String fechaFin = usuario.recall("fechaFin");
        usuario.attemptsTo(SearchFlightsByDateTask.searchFlightsByDateTask(fechaInicio, fechaFin));
    }

    @Then("se muestra una lista de vuelos disponibles en el rango de fechas")
    public void heShouldSeeTheFlightInformation() {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("airline", Matchers.everyItem(Matchers.equalTo("Airways Inc.")))));
    }

    @Then("no se muestran vuelos disponibles")
    public void heShouldSeeNoAvailableFlights() {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("size()", Matchers.equalTo(0))));
    }
}

