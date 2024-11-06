package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByNameTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightAirlineSearchStepDefinition {

    Actor usuario = Actor.named("usuario");

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("la usuaria se conecta al servicio")
    public void thatTheUserConnectsToTheService() {
        usuario.attemptsTo(ConnectTo.theService());
    }
    @And("ingresa el nombre de la aerolinea {string}")
    public void thatTheUserWantsToSearchForAFlight(String airlineName) {
        usuario.remember("airlineName", airlineName);
    }

    @When("se realiza la busqueda de vuelos por nombre de aerolinea")
    public void heEntersTheAirline() {
        String airlineName = usuario.recall("airlineName");
        usuario.attemptsTo(SearchFlightsByNameTask.searchFlightsByNameTask(airlineName));
    }
    

    @Then("se muestra una lista de vuelos de {string}")
    public void heShouldSeeTheFlightInformation(String airlineName) {
            usuario.should(seeThatResponse(response->response.statusCode(200)
                    .body("airline", Matchers.everyItem(Matchers.equalTo(airlineName)))));
    }

}
