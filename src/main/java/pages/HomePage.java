package pages;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class HomePage extends PageObject {

    @FindBy(id="user-name")
    @AndroidBy(id="notDefined")
    public static WebElementFacade USERNAME_INPUT;

    @FindBy(id="password")
    @AndroidBy(id="notDefined")
    public static WebElementFacade PWD_INPUT;

    @FindBy(id="login-button")
    @AndroidBy(id="notDefined")
    public static WebElementFacade LOGIN_BTN;

}
