package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByOriginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightOriginSearchStepDefinition {

    Actor usuario = Actor.named("usuario");
    String origin;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("los clientes se conectan al servicio")
    public void theUserConnectsToTheService() {
        usuario.attemptsTo(ConnectTo.theService());
    }
    @And("ingresa la ciudad de origen {string}")
    public void theUserEntersOriginCity(String ciudadOrigen) {
        this.origin = ciudadOrigen;
    }
    @When("se realiza la busqueda de vuelos desde la ciudad especificada")
    public void theUserSearchesForFlightsFromTheSpecifiedCity() {
        usuario.attemptsTo(SearchFlightsByOriginTask.searchFlightsByOriginTask(origin));
    }

    @Then("se muestra una lista de vuelos que salen desde {string}")
    public void theUserShouldSeeAListOfFlightsLeavingFrom(String ciudadOrigen) {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("origin", Matchers.everyItem(Matchers.equalTo(ciudadOrigen)))));
    }

    @Then("no se muestran vuelos disponibles desde {string}")
    public void noFlightsShouldBeAvailableFrom(String ciudadOrigen) {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("size()", Matchers.equalTo(0))));
    }
}
