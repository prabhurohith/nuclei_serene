package consequences;

import consequences.matchers.CustomMatcher;
import net.serenitybdd.screenplay.Consequence;
import pages.app.LoginPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CheckOnLoginPage {

    public static ArrayList<Consequence<?>> ifErrorMsgIsDisplayed(String errorMsg) {
        return new ArrayList<Consequence<?>>(List.of(
                seeThat(the(LoginPage.ERROR_MSG.waitingForNoMoreThan(Duration.ofSeconds(5))), isCurrentlyVisible()),
                seeThat(the(LoginPage.ERROR_MSG.waitingForNoMoreThan(Duration.ofSeconds(5))), CustomMatcher.containsText(errorMsg)))
        );
    }

}
