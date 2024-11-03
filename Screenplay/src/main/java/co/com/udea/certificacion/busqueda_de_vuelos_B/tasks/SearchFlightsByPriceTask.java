package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.Get;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import io.restassured.http.ContentType;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFlightsByPriceTask implements Task {

    private final String inicialPrice;
    private final String finalPrice;

    public SearchFlightsByPriceTask(String inicialPrice, String finalPrice) {
        this.inicialPrice = inicialPrice;
        this.finalPrice = finalPrice;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/searchByPrice").with(
                requestSpecification -> requestSpecification
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .param("inicialPrice", inicialPrice)
                    .param("finalPrice", finalPrice)
            )
        );
    }

    public static SearchFlightsByPriceTask searchFlightsByPriceTask(String inicialPrice, String finalPrice) {
        return instrumented(SearchFlightsByPriceTask.class, inicialPrice, finalPrice);
    }
}
