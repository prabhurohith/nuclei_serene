package starter.stepdefinitions;

import cast.TheCast;
import consequences.CheckOnLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.data.ActorInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import pages.app.LoginPage;
import pages.base.AppPages;
import tasks.navigation.NavigateTo;
import util.data.Constants;
import util.data.DataHandler;

public class LoginPageSteps {
    @Given("{actor} wants to sign in to Swag Labs")
    public void alexWantsToSignInToSwagLabs(Actor theActor) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(AppPages.HOME_PAGE.getPage()));
    }


    @When("{actor} enters user name as {string}")
    public void heEntersUserNameAsUsername(Actor theActor, String userName) {
        theActor.attemptsTo(Enter.theValue(userName).into(LoginPage.USERNAME_INPUT));
    }

    @And("{actor} clicks on login")
    public void heClicksOnLogin(Actor theActor) {
        theActor.attemptsTo(Click.on(LoginPage.LOGIN_BTN).afterWaitingUntilEnabled());
    }

    @And("{actor} enters the password as {string}")
    public void heEntersThePasswordAsPassword(Actor theActor, String userPwd) {
        theActor.attemptsTo(Enter.theValue(userPwd).into(LoginPage.PWD_INPUT));
    }

    @Then("{actor} is shown an error message as {string}")
    public void heIsShownAnErrorMessageAsError_msg(Actor theActor, String errorMsg) {
        theActor.should(
                CheckOnLoginPage.ifErrorMsgIsDisplayed(errorMsg)
        );
    }


    @Given("{actor} logs into the saucelabs app")
    public void alexLogsIntoTheSaucelabsApp(Actor theActor) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(AppPages.HOME_PAGE.getPage()));
        // See if this can be fethed directly from actor using overide
        heEntersUserNameAsUsername(theActor, TheCast.getActorInfo().getUsername());
        heEntersThePasswordAsPassword(theActor, TheCast.getActorInfo().getPassword());
        heClicksOnLogin(theActor);
    }
}
