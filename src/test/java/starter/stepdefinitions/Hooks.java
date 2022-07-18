package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

    /*    @Before
        public void setTheStage() {

    *//*        String runType = System.getProperty("run.profile");
        if(runType.contains("desktop")) {
            OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class);
        }
        else if(runType.contains("mobile"))
        {
//            OnStage.theActorInTheSpotlight().abilityTo(Device)
        }*//*
    }*/
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

}
