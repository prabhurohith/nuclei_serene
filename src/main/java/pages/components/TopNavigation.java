package pages.components;

import io.appium.java_client.pagefactory.AndroidBy;
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

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

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

    public static List<Consequence<?>> getComponentElements() {
       return List.of(seeThat(Question.about("Visibility of "+LEFT_MENU_BTN)
               .answeredBy(actor -> LEFT_MENU_BTN.withTimeoutOf(Duration.ofSeconds(5))), isCurrentlyVisible()),
               seeThat(Question.about("Visibility of "+APP_LOGO)
                       .answeredBy(actor -> APP_LOGO.withTimeoutOf(Duration.ofSeconds(5))), isCurrentlyVisible()),
               seeThat(Question.about("Visibility of "+SHOPPING_CART)
                       .answeredBy(actor -> SHOPPING_CART.withTimeoutOf(Duration.ofSeconds(5))), isCurrentlyVisible())
               );
    }
}
