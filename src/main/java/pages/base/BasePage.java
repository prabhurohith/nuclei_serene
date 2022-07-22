package pages.base;

import consequences.PageConsequences;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage extends PageObject {

    // Page load elements
    protected  List<WebElementFacade> pageElements = new ArrayList<>();
    // Component Consequences

    // Navigation Methods
    public abstract Performable navigateToPageOnWeb();

    public abstract Performable navigateToPageOnDevice();

    //Page load methods
    public  abstract BasePage registerPageElements();

    //Perform the assertion
    public void checkIfThePageIsDisplayed() {
        if (pageElements.isEmpty()) {
            throw new IllegalArgumentException("The page elements are not initialised");
        } else
            OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfThePageIsLoaded(pageElements));
    }

    public abstract void checkIfThePageIsLoaded();

}
