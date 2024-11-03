package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByNameTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightAirlineSearchStepDefinition {

    Actor usuario = Actor.named("usuario");
    final String airlineName = "JetFly";

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("el nombre de la aerolinea JetFly")
    public void thatTheUserWantsToSearchForAFlight() {
        usuario.attemptsTo(ConnectTo.theService());
    }

    @When("se realiza la busqueda de vuelos por nombre de aerolinea")
    public void heEntersTheAirline() {
        usuario.attemptsTo(SearchFlightsByNameTask.searchFlightsByNameTask(airlineName));
    }

    @Then("se muestra una lista de vuelos de JetFly")
    public void heShouldSeeTheFlightInformation() {
            usuario.should(seeThatResponse(response->response.statusCode(200)
                    .body("[0].airline", Matchers.equalTo(airlineName))));
    }

}
