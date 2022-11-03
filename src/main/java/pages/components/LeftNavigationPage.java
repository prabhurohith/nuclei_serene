package pages.components;

import consequences.PageConsequences;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import lombok.Builder;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import pages.base.BasePage;
import target.CustomTarget;
import util.data.Constants;

import java.util.List;

/**
 * Removed this off component as this is not explicitly available but on clicking the drawer appears
 */
@Builder
public class LeftNavigationPage extends BasePage {


    public static Target ALL_ITEMS = new CustomTarget()
            .namedAs("ALL_ITEMS")
            .locatedOnWebBy(By.id("inventory_sidebar_link"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-ALL ITEMS"))
            .locatedOnIOSBy(AppiumBy.accessibilityId("test-ALL ITEMS"));

    public static Target ABOUT = new CustomTarget()
            .namedAs("ABOUT")
            .locatedOnWebBy(By.id("about_sidebar_link"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().text(\"ABOUT\")"))
            .locatedOnIOSBy(AppiumBy.accessibilityId("NOt Defined"));


    public static Target LOGOUT = new CustomTarget()
            .namedAs("LOGOUT")
            .locatedOnWebBy(By.id("logout_sidebar_link"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-LOGOUT"))
            .locatedOnIOSBy(AppiumBy.accessibilityId("NOt Defined"));

    public static Target RESET_APP = new CustomTarget()
            .namedAs("RESET_APP")
            .locatedOnWebBy(By.id("reset_sidebar_link"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-RESET APP STATE"))
            .locatedOnIOSBy(AppiumBy.accessibilityId("NOt Defined"));


    public static Target CLOSE_BTN = new CustomTarget()
            .namedAs("CLOSE_BTN")
            .locatedOnWebBy(By.id("react-burger-cross-btn"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Close"))
            .locatedOnIOSBy(AppiumBy.accessibilityId("NOt Defined"));


    @Override
    public void navigateToPageOnWeb(Actor actor) {
        /**
         * Here we can implement a selective navigation
         * .ie if left navigation can only be done from home page
         *         actor.attemptsTo(Check.whether(PageInfo.getDesiredPage("")
         *          .equals(AppPages.HOME_PAGE))
         *           .andIfSo(Click.on(TopNavigation.LEFT_MENU_BTN)));
         */

        actor.attemptsTo(Click.on(TopNavigation.LEFT_MENU_BTN));
        actor.remember(Constants.LEFT_NAVIGATION_OPENED, true);
    }

    @Override
    public void navigateToPageOnDevice(Actor actor) {
        actor.attemptsTo(Click.on(TopNavigation.LEFT_MENU_BTN));
        actor.remember(Constants.LEFT_NAVIGATION_OPENED, true);
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(ABOUT, LOGOUT, RESET_APP, CLOSE_BTN));
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfElementIsDisplayed(LOGOUT));
    }
}
