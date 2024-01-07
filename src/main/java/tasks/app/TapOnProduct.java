package tasks.app;

import actions.Tap;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import pages.app.LoginPage;

public class TapOnProduct {

    public static Performable browseTheProduct(String productName) {

        return Task.where("{0} taps on " + productName,
                BrowseProduct.browseTillProductIsDisplayed(productName));
    }

    public static Performable andTap(String productName) {

        return Tap.tapOnTheProduct(OnStage.theActorInTheSpotlight()
                        .recall("elementForAction"));
    }

}
