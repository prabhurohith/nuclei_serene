package pages.base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;

public abstract class BasePage extends PageObject{

    public abstract Performable navigateToPageOnWeb();
    public abstract Performable navigateToPageOnDevice();
}
