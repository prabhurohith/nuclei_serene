package starter.stepdefinitions;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.openqa.selenium.InvalidArgumentException;
import questions.EnvironmentInfo;
import util.MockHandler;

import java.util.Optional;

public class Hooks {

    @BeforeAll
    public static void setupReporting() {
        //This is for report prtal
//        configureReporting();

        //If the test is API the start teh mock
//        MockHandler.startMockingForAPI();
//        System.out.println("Hooks called bfore all");
    }

    @Before
    public void setTheStage() {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            OnStage.setTheStage(new OnlineCast());
//            OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class);
        } else if (EnvironmentInfo.getRunProfile().toLowerCase().contains("device")) {
            OnStage.setTheStage(new OnlineCast());
        } else if (EnvironmentInfo.getRunProfile().toLowerCase().contains("api")) {
            OnStage.setTheStage(new OnlineCast());
        }
    }

    @After
    public void cleanTheStage() {
        OnStage.drawTheCurtain();
//        MockHandler.stopMockingForAPI();
//        System.out.println("Hooks called after");

    }

    private static void configureReporting() {
        System.setProperty("rp.attributes", "platform:" + EnvironmentInfo.getRunProfile().toLowerCase());
        System.setProperty("rp.launch", "Test_" + EnvironmentInfo.getRunProfile().toLowerCase());
    }

}
