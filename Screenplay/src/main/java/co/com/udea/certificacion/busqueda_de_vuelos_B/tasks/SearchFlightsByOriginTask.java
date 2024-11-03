package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.Get;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import io.restassured.http.ContentType;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlightsByOriginTask implements Task {

    private final String cityOfOrigin;

    public SearchFlightsByOriginTask(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/searchByOrigin").with(
                requestSpecification -> requestSpecification
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .param("cityOfOrigin", cityOfOrigin)
            )
        );
    }

    public static SearchFlightsByOriginTask searchFlightsByOriginTask(String cityOfOrigin) {
        return instrumented(SearchFlightsByOriginTask.class, cityOfOrigin);
    }
}
