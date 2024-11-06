package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByDestinationTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightDestinationSearch {
    Actor usuario = Actor.named("usuario");

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("el cliente se conecta al servicio")
    public void thatTheUserWantsToConnectToTheService() {
        usuario.attemptsTo(ConnectTo.theService());
    }
    
    @And("ingresa la ciudad de destino {string}")
    public void thatTheUserWantsToSearchForFlightsToCity(String ciudadDestino) {
        usuario.remember("ciudadDestino", ciudadDestino);
    }

    @When("se realiza la busqueda de vuelos hacia la ciudad especificada")
    public void heSearchesForFlightsToTheSpecifiedCity() {
        String ciudadDestino = usuario.recall("ciudadDestino");
        usuario.attemptsTo(SearchFlightsByDestinationTask.searchFlightsByDestinationTask(ciudadDestino));
    }

    @Then("se muestra una lista de vuelos que llegan a {string}")
    public void heShouldSeeFlightsToCity(String ciudadDestino) {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("destination", Matchers.everyItem(Matchers.equalTo(ciudadDestino)))));
    }

    @Then("no se muestran vuelos disponibles hacia {string}")
    public void heShouldSeeNoAvailableFlightsToCity(String ciudadDestino) {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("size()", Matchers.equalTo(0)))); 
    }
}