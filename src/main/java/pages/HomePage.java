package pages;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

@DefaultUrl("page:home.page")
public class HomePage extends BasePage {

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


    @Override
    public Performable navigateToPageOnWeb() {
        return Task.where("{0} opens the Swag Labs Home Page",
                Open.browserOn().the(HomePage.class));
    }

    @Override
    public Performable navigateToPageOnDevice() {
        throw new IllegalArgumentException("Navigation not implemented");
    }
}
