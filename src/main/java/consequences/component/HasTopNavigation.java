package consequences.component;

import net.serenitybdd.core.pages.WebElementFacade;
import pages.components.TopNavigation;

import java.util.List;

public interface HasTopNavigation {

    public void registerTheTopNavigation();

    default List<WebElementFacade> getComponentElements() {
        return TopNavigation.getComponentElements();
    }

}
