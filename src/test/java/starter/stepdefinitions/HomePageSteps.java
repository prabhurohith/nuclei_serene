package starter.stepdefinitions;

import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import pages.components.LeftNavigationPage;
import pages.components.TopNavigation;
import util.data.Constants;

public class HomePageSteps {
    @And("{actor} opens the left navigation")
    public void heOpensTheLeftNavigation(Actor theActor) {
        theActor.attemptsTo(Click.on(TopNavigation.LEFT_MENU_BTN));
        theActor.remember(Constants.LEFT_NAVIGATION_OPENED, true);
        LeftNavigationPage.builder().build().configureTheComponent();
    }
}
