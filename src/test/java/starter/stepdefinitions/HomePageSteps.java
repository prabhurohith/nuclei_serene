package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import pages.app.HomePage;
import pages.base.AppPages;
import pages.components.LeftNavigationPage;
import pages.components.TopNavigation;
import questions.PageInfo;
import tasks.app.TapOnProduct;
import tasks.navigation.NavigateTo;
import util.data.Constants;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageSteps {
    @And("{actor} opens the left navigation")
    public void heOpensTheLeftNavigation(Actor theActor) {
        theActor.attemptsTo(NavigateTo.navigateToThePage(AppPages.LEFT_NAVIGATION_PAGE.getPage()));
    }

    @When("{actor} sorts the results by {string} in {string}")
    public void heSortsTheResultsBySort_categoryInSort_type(Actor theActor, String sortCategory, String sortType) {

        theActor.attemptsTo(Click.on(HomePage.SORT_FILTER));
        switch (sortCategory + "_" + sortType) {
            case "Name_Ascending":
                theActor.attemptsTo(Click.on(HomePage.ASCENDING_NAME_SORT));
                break;
            case "Name_Descending":
                theActor.attemptsTo(Click.on(HomePage.DESCENDING_NAME_SORT));
                break;
            case "Price_From_Lowest":
                theActor.attemptsTo(Click.on(HomePage.PRICE_FROM_LOW_SORT));
                break;
            case "Price_From_Highest":
                theActor.attemptsTo(Click.on(HomePage.PRICE_FROM_HIGH_SORT));
                break;
            default:
                throw new IllegalArgumentException("Please select a valid sort");
        }
    }

    @Then("{actor} should be able to see the search results are sorted by {string} in {string}")
    public void heShouldBeAbleToSeeTheSearchResultsAreSortedBySort_categoryInSort_type(Actor theActor, String sortCategory, String sortType) {
        List<String> allText = theActor.asksFor(PageInfo.getTextOfAllElements(HomePage.PRODUCT_TITLE));

        /**
         * Please use seeThat for soft asserts
         */
        switch (sortCategory + "_" + sortType) {
            case "Name_Ascending":
                theActor.attemptsTo(Ensure.that(allText).isEqualTo(allText.stream().sorted().collect(Collectors.toList())));
                break;
            case "Name_Descending":
                theActor.attemptsTo(Ensure.that(allText).isEqualTo(allText.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList())));
                break;
            case "Price_From_Lowest":
                theActor.attemptsTo(Click.on(HomePage.PRICE_FROM_LOW_SORT));
                break;
            case "Price_From_Highest":
                theActor.attemptsTo(Click.on(HomePage.PRICE_FROM_HIGH_SORT));
                break;
            default:
                throw new IllegalArgumentException("Please select a valid sort");
        }
    }

    @And("he taps on the {string} product")
    public void heTapsOnTheSauceLabsBackpackProduct(String prodName) {
        OnStage.theActorInTheSpotlight().attemptsTo(TapOnProduct.browseTheProduct(prodName));
        OnStage.theActorInTheSpotlight().attemptsTo(TapOnProduct.andTap(prodName));
    }
}
