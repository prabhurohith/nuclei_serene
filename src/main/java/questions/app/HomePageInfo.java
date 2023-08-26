package questions.app;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import pages.base.AppPages;
import pages.base.BasePage;
import questions.EnvironmentInfo;
import util.data.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HomePageInfo {


    public static Question<Boolean> checkIfElementIsDisplayedInView(Target desiredTarget, String desiredTargetVal) {
        String attributeVal;
        if (EnvironmentInfo.getExecutionType() == Constants.ExecutionType.MOBILE) {
            boolean isElemPresent = desiredTarget.resolveAllFor(OnStage.theActorInTheSpotlight()).stream().filter(indVal->indVal.getText().equalsIgnoreCase(desiredTargetVal)).findAny().isPresent();
            return Question.about("The text of the element").answeredBy(actor -> isElemPresent);
        } else {
            boolean isElemPresent = desiredTarget.resolveAllFor(OnStage.theActorInTheSpotlight()).stream().filter(indVal->indVal.getText().equalsIgnoreCase(desiredTargetVal)).findAny().isPresent();
            return Question.about("The text of the element").answeredBy(actor -> isElemPresent);
        }
    }

}
