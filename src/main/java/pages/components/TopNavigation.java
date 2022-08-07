package pages.components;

import io.appium.java_client.pagefactory.AndroidBy;
import lombok.Builder;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenPageFromClass;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.pages.PageFactory;
import net.thucydides.core.webdriver.DefaultPageObjectInitialiser;
import org.openqa.selenium.devtools.v85.page.Page;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

@Builder
@Getter
public class TopNavigation extends PageObject  {

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
