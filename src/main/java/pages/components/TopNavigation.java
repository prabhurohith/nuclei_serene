package pages.components;

import io.appium.java_client.pagefactory.AndroidBy;
import lombok.Builder;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.pages.PageFactory;

import java.util.List;

@Builder
@Getter
public class TopNavigation extends PageObject  implements IsComponent{

    @FindBy(id = "react-burger-menu-btn")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade LEFT_MENU_BTN;

    @FindBy(className = "app_logo")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade APP_LOGO;

    @FindBy(id = "shopping_cart_container")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade SHOPPING_CART;

    public void configureTheComponent() {
        new PageFactory(Serenity.getDriver()).createPageOfType(TopNavigation.class);
    }


    public static List<WebElementFacade> getComponentElements() {
        return List.of(LEFT_MENU_BTN, APP_LOGO, SHOPPING_CART);
    }


}
