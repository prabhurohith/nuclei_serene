package consequences.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CheckResponse {
    public static ArrayList<Consequence<?>> forSuccessfulCreation() {
        return new ArrayList<>(List.of(
                seeThat(Question.about("Response is successful")
                        .answeredBy(actor -> ((Integer) SerenityRest.lastResponse().getStatusCode()).equals(200)))
        ));
    }


}
