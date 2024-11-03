package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.Get;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import io.restassured.http.ContentType;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlightsByNameTask implements Task {

    private final String nameAirline;

    public SearchFlightsByNameTask(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/searchByName").with(
                requestSpecification -> requestSpecification
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .param("nameAirline", nameAirline)
            )
        );
    }

    public static SearchFlightsByNameTask searchFlightsByNameTask(String nameAirline) {
        return instrumented(SearchFlightsByNameTask.class, nameAirline);
    }
}
