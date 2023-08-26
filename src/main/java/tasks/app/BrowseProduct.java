package tasks.app;

import actions.Browse;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import pages.app.HomePage;
import pages.app.LoginPage;

public class BrowseProduct {
    public static Performable browseTillProductIsDisplayed(String productName) {
        return Task.where("{0} tries to scroll till product is displayed" ,
                Browse.forProducts(HomePage.PRODUCT_TITLE,productName,HomePage.PRODUCT_IMAGE)
                );
    }
}
