package pages.app;

import consequences.PageConsequences;
import consequences.component.HasTopNavigation;
import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.DefaultUrl;
import pages.base.BasePage;
import pages.components.TopNavigation;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static pages.components.TopNavigation.*;

@DefaultUrl("page:home.page")
public class HomePage extends BasePage implements HasTopNavigation {

    @FindBy(className = "header_secondary_container")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade PRODUCTS_HEADER;

    @FindBy(className = "peek")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade PEEK_PRODUCT_LOGO;

    @FindBy(className = "right_component")
    @AndroidBy(id = "notDefined")
    public static WebElementFacade SORT_FILTER;

    @Override
    public void navigateToPageOnWeb(Actor theActor) {
        theActor.should(PageConsequences.checkIfElementIsDisplayed(PRODUCTS_HEADER));
    }

    @Override
    public void navigateToPageOnDevice(Actor theActor) {
        throw new IllegalArgumentException("Navigation not implemented");
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(PRODUCTS_HEADER, PEEK_PRODUCT_LOGO, SORT_FILTER));
        registerTheTopNavigation();
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        throw new IllegalArgumentException("Page load condition not defined");
    }

    @Override
    public void registerTheTopNavigation() {
        TopNavigation.builder().build().configureTheComponent();
        super.pageElements.addAll(getComponentElements());
    }
}
