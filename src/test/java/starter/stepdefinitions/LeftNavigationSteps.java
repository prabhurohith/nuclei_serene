package starter.stepdefinitions;

import consequences.CheckLeftNavigation;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import pages.components.TopNavigation;

public class LeftNavigationSteps {
    @Then("{actor} should see that the left navigation options are displayed")
    public void heShouldSeeThatTheLeftNavigationOptionsAreDisplayed(Actor theActor) {
        theActor.should(CheckLeftNavigation.ifLeftNavigationIsDisplayed());
    }
}
