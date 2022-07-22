package pages.app;

import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageFactory;
import pages.base.BasePage;

import java.util.List;

@DefaultUrl("page:home.page")
public class HomePage extends BasePage {

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
    public Performable navigateToPageOnWeb() {
        return Task.where("{0} opens the Swag Labs Home Page",
                Open.browserOn().the(HomePage.class));
    }

    @Override
    public Performable navigateToPageOnDevice() {
        throw new IllegalArgumentException("Navigation not implemented");
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(PRODUCTS_HEADER,PEEK_PRODUCT_LOGO,SORT_FILTER));
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        throw new IllegalArgumentException("Page load condtion not defined");
    }
}
