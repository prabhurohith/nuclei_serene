package pages.components;

import io.appium.java_client.pagefactory.AndroidBy;
import lombok.Builder;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.pages.PageFactory;

import java.util.List;

@Builder
public class LeftNavigationPage extends PageObject implements IsComponent{

    @FindBy(id = "inventory_sidebar_link")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade ALL_ITEMS;

    @FindBy(id = "about_sidebar_link")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade ABOUT;

    @FindBy(id = "logout_sidebar_link")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade LOGOUT;

    @FindBy(id = "reset_sidebar_link")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade RESET_APP;

    @FindBy(id = "react-burger-cross-btn")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade CLOSE_BTN;


    @Override
    public void configureTheComponent() {
        new PageFactory(Serenity.getDriver()).createPageOfType(LeftNavigationPage.class);
    }

    public static List<WebElementFacade> getComponentElements() {
        return List.of(ABOUT, LOGOUT, RESET_APP,CLOSE_BTN);
    }

}
