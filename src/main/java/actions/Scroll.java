package actions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Instant;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Scroll {

    public static Performable swipeDownAcrossElement(WebElementFacade elementToBeScrolled)
    {
        return Task.where("Scrolling element into view",
                actor -> ((AppiumDriver)(((WebDriverFacade) Serenity.getDriver()).getProxiedDriver()))
                        .executeScript("gesture: swipe", Map.of("elementId", ((RemoteWebElement)elementToBeScrolled.getElement()).getId(),
                        "percentage", 70,
                        "direction", "up")));
    }
}
