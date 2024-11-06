package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import org.hamcrest.Matchers;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlightsByPriceTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
public class FlightPriceSearchStepDefinition {
    
    Actor usuario = Actor.named("usuario");

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }
    @Given("los usuarios se conectan al servicio")
    public void theUserConnectsToTheService() {
        usuario.attemptsTo(ConnectTo.theService());

    }
    @And("ingresa un precio inicial {string} y un precio final {string}")
    public void heEntersThePrices(String precioInicial, String precioFinal) {
        usuario.remember("precioInicial", precioInicial);
        usuario.remember("precioFinal", precioFinal);
    }

    @When("se realiza la busqueda de vuelos entre los precios especificados")
    public void thatTheUserWantsToSearchForAFlight() {
        String precioInicial = usuario.recall("precioInicial");
        String precioFinal = usuario.recall("precioFinal");
        
        usuario.attemptsTo(SearchFlightsByPriceTask.searchFlightsByPriceTask(precioInicial, precioFinal));
    }    
    @Then("se muestra una lista de vuelos disponibles dentro del rango de precios")
    public void heShouldSeeTheFlightInformation() {
        int precioInicial = Integer.parseInt(usuario.recall("precioInicial"));
        int precioFinal = Integer.parseInt(usuario.recall("precioFinal"));
        usuario.should(seeThatResponse(response -> response.statusCode(200)
                .body("price", Matchers.everyItem(Matchers.allOf(
                        Matchers.greaterThanOrEqualTo(precioInicial),
                        Matchers.lessThanOrEqualTo(precioFinal)
                )))));
    }
    
    @Then("no se muestran vuelos disponibles dentro del rango de precios")
    public void heShouldSeeNoAvailableFlightss() {
        usuario.should(seeThatResponse(response -> response.statusCode(200)
            .body("size()", Matchers.equalTo(0))));
    }
}