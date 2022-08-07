package consequences.component;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import pages.app.HomePage;
import pages.components.TopNavigation;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public interface HasTopNavigation {

    public void registerTheTopNavigation();

    default List<WebElementFacade> getComponentElements() {
        TopNavigation.builder().build().configureTheComponent();
        return TopNavigation.getComponentElements();
    }

}
