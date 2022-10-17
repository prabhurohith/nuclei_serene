package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import pages.base.AppPages;
import pages.base.BasePage;
import util.data.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PageInfo {

    public static Question<Optional<BasePage>> getDesiredPage(String pageName) {
        Optional<BasePage> desiredPage = Optional
                .ofNullable(AppPages.getAllPages().stream().filter(indPage -> indPage.getPageName().equalsIgnoreCase(pageName)).findFirst().get().getPage());
        return Question.about("The current Page").answeredBy(actor -> desiredPage);
    }

    public static Question<String> getText(Target desiredTarget) {
        String attributeVal;
        if (EnvironmentInfo.getExecutionType() == Constants.ExecutionType.MOBILE) {
            attributeVal = "text";
        } else
            attributeVal = "textContent";
        return Question.about("The text of the element").answeredBy(actor -> desiredTarget.resolveFor(actor).getAttribute(attributeVal));
    }

    public static Question<List<String>> getTextOfAllElements(Target desiredTarget) {
        String attributeVal;
        if (EnvironmentInfo.getExecutionType() == Constants.ExecutionType.MOBILE) {
            List<String> allText = new ArrayList<String>();
            desiredTarget.resolveAllFor(OnStage.theActorInTheSpotlight()).forEach(indVal -> allText.add(indVal.getAttribute("text")));
            return Question.about("The text of the element").answeredBy(actor -> allText);
        } else {
            System.out.println(desiredTarget.resolveAllFor(OnStage.theActorInTheSpotlight()).textContents());
            return Question.about("The text of the element").answeredBy(actor -> desiredTarget.resolveAllFor(actor).textContents());
        }
    }

}
