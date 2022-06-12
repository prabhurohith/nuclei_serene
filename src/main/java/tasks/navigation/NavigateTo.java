package tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.HomePage;
import pages.base.BasePage;
import questions.EnvironmentInfo;

public class NavigateTo {
    public static Performable theWikipediaHomePage() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }


    public static Performable navigateToThePage(BasePage desiredPage)
    {
        if(EnvironmentInfo.getPlatformName().toLowerCase().contains("web"))
        {
            return desiredPage.navigateToPageOnWeb();
        }
        else
        {
            return desiredPage.navigateToPageOnDevice();
        }
    }
}
