package co.com.udea.certificacion.busqueda_de_vuelos_B.runners.flightrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/searchbydestination.feature",
        glue = "co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class FlightDestinationSearchRunner {}