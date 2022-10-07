package starter.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.EnvironmentInfo;

public class Hooks {

    @Before
    public void setTheStage() {

        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            OnStage.setTheStage(new OnlineCast());
//            OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class);

        } else if (EnvironmentInfo.getRunProfile().toLowerCase().contains("device")) {
            OnStage.setTheStage(new OnlineCast());
        }
    }
/*    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }*/

}
