package consequences;

import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class PageConsequences {

    public static List<Consequence<?>> checkIfThePageIsDisplayed(List<Target> allPageTargets) {
        List<Consequence<?>> elementLoadConsequences = new ArrayList<Consequence<?>>();
        allPageTargets.forEach(indTarget -> elementLoadConsequences.add(seeThat(the(indTarget.waitingForNoMoreThan(Duration.ofSeconds(5))), isCurrentlyVisible())));
        return elementLoadConsequences;
    }

    public static Consequence<?> checkIfElementIsDisplayed(Target targetElement) {
        return seeThat(the(targetElement.waitingForNoMoreThan(Duration.ofSeconds(10))), isCurrentlyVisible());
    }
}
