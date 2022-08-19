package consequences;

import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import pages.app.LoginPage;
import pages.components.LeftNavigationPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class CheckLeftNavigation {

    public static List<Consequence<?>> ifLeftNavigationIsDisplayed() {
        List<Consequence<?>> leftNavConsequences = new ArrayList<>();
        LeftNavigationPage.getComponentElements().forEach(indElement -> leftNavConsequences
                .add(seeThat(Question.about(" Visibility of ")
                        .answeredBy(actor -> indElement.waitUntilVisible().withTimeoutOf(Duration.ofSeconds(5))), isCurrentlyVisible())));
        return leftNavConsequences;
    }
}
