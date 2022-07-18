package pages.components;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class TopNavigation {

    @FindBy(id = "react-burger-menu-btn")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade LEFT_MENU_BTN;

    @FindBy(className = "app_logo")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade APP_LOGO;

    @FindBy(id = "shopping_cart_container")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade SHOPPING_CART;
}
