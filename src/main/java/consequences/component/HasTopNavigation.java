package consequences.component;

import net.serenitybdd.screenplay.targets.Target;
import pages.components.TopNavigation;

import java.util.List;

public interface HasTopNavigation {

    public void registerTheTopNavigation();

    default List<Target> getComponentElements() {
        return TopNavigation.getComponentElements();
    }

}
