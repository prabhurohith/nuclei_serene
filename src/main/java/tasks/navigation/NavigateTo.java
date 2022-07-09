package tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import pages.base.BasePage;
import questions.EnvironmentInfo;

public class NavigateTo {


    public static Performable navigateToThePage(BasePage desiredPage) {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            return desiredPage.navigateToPageOnWeb();
        } else {
            return desiredPage.navigateToPageOnDevice();
        }
    }
}
