package starter.stepdefinitions;

import cast.TheCast;
import consequences.CheckOnLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pages.app.LoginPage;
import pages.base.AppPages;
import tasks.app.Login;
import tasks.navigation.NavigateTo;

import java.util.List;
import java.util.Map;

public class LoginPageSteps {
    @Given("{actor} wants to sign in to Swag Labs")
    public void alexWantsToSignInToSwagLabs(Actor theActor) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(AppPages.LOGIN_PAGE.getPage()));
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

    /**
     * Rather than showing individual entries / actions for user encapsulating the user actions in Login class with Task within it
     * @param theActor
     * @param table
     */
    @Given("{actor} has logged into the saucelabs app with the below credentials")
    public void userHasLoggedIntoTheSaucelabsAppWithTheBelowCredentials(Actor theActor, DataTable table) {
        alexWantsToSignInToSwagLabs(theActor);
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            theActor.attemptsTo(Login.as(columns.get("username"), columns.get("password")));
        }
    }


    @Given("{actor} logs into the saucelabs app")
    @Given("{actor} logs into the app")
    public void alexLogsIntoTheSaucelabsApp(Actor theActor) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(AppPages.LOGIN_PAGE.getPage()));
        heEntersUserNameAsUsername(theActor, TheCast.getActorInfo().getUsername());
        heEntersThePasswordAsPassword(theActor, TheCast.getActorInfo().getPassword());
        heClicksOnLogin(theActor);
    }


}
