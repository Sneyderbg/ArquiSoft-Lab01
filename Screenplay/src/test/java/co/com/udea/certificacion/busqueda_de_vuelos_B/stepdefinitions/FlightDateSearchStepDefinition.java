package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByDateTask;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByNameTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FlightDateSearchStepDefinition {
  Actor usuario = Actor.named("usuario");

    final String fechaInicio = "2023-01-01";
    final String fechaFin = "2024-01-02";

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("una fecha de inicio 2023-01-01 y una fecha de fin 2024-01-02")
    public void thatTheUserWantsToSearchForAFlight() {
        usuario.attemptsTo(ConnectTo.theService());
    }

    @When("se realiza la busqueda de vuelos entre las fechas especificadas")
    public void heEntersTheAirline() {
        usuario.attemptsTo(SearchFlightsByDateTask.searchFlightsByDateTask(fechaInicio, fechaFin));
    }

    @Then("se muestra una lista de vuelos disponibles en el rango de fechas")
    public void heShouldSeeTheFlightInformation() {
            usuario.should(seeThatResponse(response->response.statusCode(200)
                    .body("[0].airline", Matchers.equalTo("Airways Inc."))));
    }
}
