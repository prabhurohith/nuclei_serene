package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pages.HomePage;
import tasks.navigation.NavigateTo;

public class HomePageSteps {
    @Given("{actor} wants to sign in to Swag Labs")
    public void alexWantsToSignInToSwagLabs(Actor theActor) {
        theActor.attemptsTo(NavigateTo.theSwagLabsHomePage());
    }


    @When("{actor} enters user name as {word}")
    public void heEntersUserNameAsUsername(Actor theActor, String userName) {
        theActor.attemptsTo(Enter.theValue(userName).into(HomePage.USERNAME_INPUT));
    }

    @And("{actor} clicks on login")
    public void heClicksOnLogin(Actor theActor) {
        theActor.attemptsTo(Click.on(HomePage.LOGIN_BTN).afterWaitingUntilEnabled());
    }

    @And("{actor} enters the password as {string}")
    public void heEntersThePasswordAsPassword(Actor theActor, String userPwd) {
        theActor.attemptsTo(Enter.theValue(userPwd).into(HomePage.PWD_INPUT));
    }
}
