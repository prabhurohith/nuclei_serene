package consequences;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class PageConsequences {

    public static List<Consequence<?>> checkIfThePageIsLoaded(List<WebElementFacade> allPageTargets) {
        List<Consequence<?>> elementLoadConsequences = new ArrayList<Consequence<?>>();
        allPageTargets.forEach(indTarget -> elementLoadConsequences.add(seeThat(Question.about("The target Visibility")
                .answeredBy(actor -> indTarget.withTimeoutOf(Duration.ofSeconds(5))), isCurrentlyVisible())));
        return elementLoadConsequences;
    }
}
