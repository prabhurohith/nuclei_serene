package pages.app;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import pages.base.BasePage;
import target.CustomTarget;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@DefaultUrl("page:login.page")
public class LoginPage extends BasePage {

/*
    @FindBy(id = "user-name")
    @AndroidBy(accessibility = "test-Username")
    public static WebElementFacade USERNAME_INPUT;
*/

    public static Target USERNAME_INPUT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("user-name"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Username"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));


    public static Target PWD_INPUT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("password"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Password"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target LOGIN_BTN = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("login-button"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-LOGIN"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target ERROR_MSG = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.xpath("//h3[@data-test='error']"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));



    @Override
    public void navigateToPageOnWeb(Actor theActor) {
        theActor.attemptsTo(Open.browserOn().the(LoginPage.class));
    }

    @Override
    public void navigateToPageOnDevice(Actor theActor) {
        theActor.should(seeThat(the(USERNAME_INPUT), WebElementStateMatchers.isVisible())
                .after(Wait.until(the(USERNAME_INPUT), WebElementStateMatchers.isVisible()).forNoMoreThan(Duration.ofSeconds(5))));
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(USERNAME_INPUT,PWD_INPUT, LOGIN_BTN));
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        throw new IllegalArgumentException("Page load condtion not defined");
    }
}
