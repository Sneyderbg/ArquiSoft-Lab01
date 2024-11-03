package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.Get;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import io.restassured.http.ContentType;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlightsByDateTask implements Task {

    private final String startDate;
    private final String endDate;

    public SearchFlightsByDateTask(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/search").with(
                requestSpecification -> requestSpecification
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .param("startDate", startDate)
                    .param("endDate", endDate)
            )
        );
    }

    public static SearchFlightsByDateTask searchFlightsByDateTask(String startDate, String endDate) {
        return instrumented(SearchFlightsByDateTask.class, startDate, endDate);
    }
}
