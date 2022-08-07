package pages.app;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import pages.base.BasePage;

import java.util.List;

@DefaultUrl("page:login.page")
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade USERNAME_INPUT;

    @FindBy(id = "password")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade PWD_INPUT;

    @FindBy(id = "login-button")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade LOGIN_BTN;

    @FindBy(xpath = "//h3[@data-test='error']")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade ERROR_MSG;

/*
    public static final Target ERROR_MSG = Target.the("Error Msg")
           .located(By.xpath("//h3[@data-test='error'"));
*/


    @Override
    public void navigateToPageOnWeb(Actor theActor) {
        theActor.attemptsTo(Open.browserOn().the(LoginPage.class));
    }

    @Override
    public void navigateToPageOnDevice(Actor theActor) {
        throw new IllegalArgumentException("Navigation not implemented");
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(USERNAME_INPUT, PWD_INPUT, LOGIN_BTN));
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        throw new IllegalArgumentException("Page load condtion not defined");
    }
}
