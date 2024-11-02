package co.com.udea.certificacion.busqueda_de_vuelos_b.runners.flightrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/flightoriginsearch/.../",
        glue = "co.com.udea.certificacion.busqueda_de_vuelos_b.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class FlightOriginSearchRunner {}