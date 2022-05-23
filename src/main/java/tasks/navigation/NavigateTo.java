package tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.HomePage;

public class NavigateTo {
    public static Performable theWikipediaHomePage() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }

    public static Performable theSwagLabsHomePage()
    {
        return Task.where("{0} opens the Swag Labs Home Page",
               Open.browserOn().the(HomePage.class));
    }
}
