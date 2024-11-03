package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.Get;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import io.restassured.http.ContentType;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlightsByDestinationTask implements Task {

    private final String cityOfDestination;

    public SearchFlightsByDestinationTask(String cityOfDestination) {
        this.cityOfDestination = cityOfDestination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/searchByDestination").with(
                requestSpecification -> requestSpecification
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .param("cityOfDestination", cityOfDestination)
            )
        );
    }

    public static SearchFlightsByDestinationTask searchFlightsByDestinationTask(String cityOfDestination) {
        return instrumented(SearchFlightsByDestinationTask.class, cityOfDestination);
    }
}
