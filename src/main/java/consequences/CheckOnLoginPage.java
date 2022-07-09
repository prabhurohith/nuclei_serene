package consequences;

import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import pages.app.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CheckOnLoginPage {

    public static ArrayList<Consequence<?>> ifErrorMsgIsDisplayed(String errorMsg) {
        return new ArrayList<Consequence<?>>(List.of(
                seeThat(Question.about("Error Msg Visibility").answeredBy(actor -> LoginPage.ERROR_MSG),isCurrentlyVisible()),
                seeThat(Question.about("Error Msg Content").answeredBy(actor -> LoginPage.ERROR_MSG), containsText(errorMsg))
        ));
    }

}
