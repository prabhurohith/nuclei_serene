package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import questions.PageInfo;
import tasks.navigation.NavigateTo;

public class CommonSteps {

    @SneakyThrows
    @Given("{actor} goes to the saucelabs {string} page")
    public void goesToThePage(Actor theActor, String pageName) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(PageInfo.getDesiredPage(pageName).answeredBy(theActor)
                .orElseThrow(() -> new IllegalArgumentException("Page not defined in the page"))));
    }

    @Then("{actor} should be able to see that the {string} page is complete displayed")
    public void heShouldBeAbleToSeeThatThePageIsDisplayed(Actor theActor, String pageName) {
        PageInfo.getDesiredPage(pageName).answeredBy(theActor)
                .orElseThrow(() -> new IllegalArgumentException("Page not defined in the page"))
                .registerPageElements()
                .checkIfThePageIsDisplayed();
    }

    @Then("{actor} should be able to see that the {string} page is loaded")
    public void heShouldBeAbleToSeeThatThePageIsLoaded(Actor theActor, String pageName) {
        PageInfo.getDesiredPage(pageName).answeredBy(theActor)
                .orElseThrow(() -> new IllegalArgumentException("Page not defined in the page"))
                .registerPageElements()
                .checkIfThePageIsLoaded();
    }

    @Then("{actor} should see that the {string} options are displayed")
    public void heShouldBeAbleToSeeThatTheComponentIsDisplayed(Actor theActor, String pageName) {
        PageInfo.getDesiredPage(pageName).answeredBy(theActor)
                .orElseThrow(() -> new IllegalArgumentException("Page not defined in the page"))
                .registerPageElements()
                .checkIfThePageIsDisplayed();
    }

}
