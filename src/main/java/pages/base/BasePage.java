package pages.base;

import com.google.common.base.Predicate;
import consequences.PageConsequences;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage extends PageObject {

    // Page load elements
    protected List<Target> pageElements = new ArrayList<>();

    // Component Consequences

    // Navigation Methods
    public abstract void navigateToPageOnWeb(Actor actor);

    public abstract void navigateToPageOnDevice(Actor actor);

    //Page load methods
    public abstract BasePage registerPageElements();

    //Perform the assertion
    public void checkIfThePageIsDisplayed() {
        if (pageElements.isEmpty()) {
            throw new IllegalArgumentException("The page elements are not initialised");
        } else
            OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfThePageIsDisplayed(pageElements));
    }

    public abstract void checkIfThePageIsLoaded();

/*    public BasePage(final WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(PageObject page) {
                PageFactory
                        .initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver(),
                                page.getImplicitWaitTimeout()), page);
                return true;
            }
        });

    }*/

}
