package tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import pages.base.BasePage;
import questions.EnvironmentInfo;

public class NavigateTo {
    public static Performable navigateToThePage(BasePage desiredPage) {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            return Task.where("Actor is navigating ", actor -> desiredPage.navigateToPageOnWeb(actor));
//            return desiredPage.navigateToPageOnWeb(OnStage.theActorInTheSpotlight());
        } else {
            return Task.where("Actor is navigating ", actor -> desiredPage.navigateToPageOnDevice(actor));

//            return desiredPage.navigateToPageOnDevice(OnStage.theActorInTheSpotlight());
        }
    }
}
