package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.EnvironmentInfo;

public class Hooks {

    @BeforeAll
    public static void setupReporting() {
        configureReporting();
    }

    @Before
    public void setTheStage() {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            OnStage.setTheStage(new OnlineCast());
//            OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class);

        } else if (EnvironmentInfo.getRunProfile().toLowerCase().contains("device")) {
            OnStage.setTheStage(new OnlineCast());
        }
    }

    @After
    public void cleanTheStage() {
        OnStage.drawTheCurtain();
    }

    private static void configureReporting() {
        System.setProperty("rp.attributes", "platform:" + EnvironmentInfo.getRunProfile().toLowerCase());
        System.setProperty("rp.launch", "Test_" + EnvironmentInfo.getRunProfile().toLowerCase());
    }

}
