package starter.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

public class Hooks {

    @Before
    public void setTheStage() {
/*        String runType = System.getProperty("run.profile");
        if(runType.contains("desktop")) {
            OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class);
        }
        else if(runType.contains("mobile"))
        {
//            OnStage.theActorInTheSpotlight().abilityTo(Device)
        }*/
    }
}
