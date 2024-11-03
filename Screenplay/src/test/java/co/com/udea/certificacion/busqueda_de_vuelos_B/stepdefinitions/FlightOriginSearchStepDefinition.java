package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByNameTask;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByOriginTask;
import io.cucumber.java.Before;
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

    @Given("el usuario se conecta al servicio e ingresa la ciudad de origen Bogota")
    public void theUserConnectsToTheServiceAndEntersOriginCityBogota() {
        this.origin = "Bogota";
        usuario.attemptsTo(ConnectTo.theService());
    }

    @When("se realiza la busqueda de vuelos desde la ciudad especificada")
    public void theUserSearchesForFlightsFromTheSpecifiedCity() {
        usuario.attemptsTo(SearchFlightsByOriginTask.searchFlightsByOriginTask(origin));
    }

    @Then("se muestra una lista de vuelos que salen desde Bogota")
    public void theUserShouldSeeAListOfFlightsLeavingFromBogota() {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("[0].origin", Matchers.equalTo(origin))));
    }

    @Given("el usuario se conecta al servicio e ingresa la ciudad de origen CiudadInexistente")
    public void theUserConnectsToTheServiceAndEntersOriginCityCiudadInexistente() {
        this.origin = "CiudadInexistente";
        usuario.attemptsTo(ConnectTo.theService());
    }

    @When("se realiza la busqueda de vuelos desde la ciudad inexistente especificada")
    public void theUserSearchesForFlightsFromTheSpecifiedCityCiudadInexistente() {
        usuario.attemptsTo(SearchFlightsByOriginTask.searchFlightsByOriginTask(origin));
    }

    @Then("no se muestran vuelos disponibles desde CiudadInexistente")
    public void noFlightsShouldBeAvailableFromCiudadInexistente() {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("size()", Matchers.equalTo(0))));
    }
}
