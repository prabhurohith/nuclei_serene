package pages.app;

import consequences.PageConsequences;
import consequences.component.HasTopNavigation;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import pages.base.BasePage;
import pages.components.TopNavigation;
import target.CustomTarget;

import java.util.List;

@DefaultUrl("page:home.page")
public class DrawingPage extends BasePage implements HasTopNavigation {
    /**
     * This Page has been implemented to show the  fluent interface in branching , actual locators are not implemented
     */

    public static Target DRAWING_HEADER = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("header_secondary_container"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target DRAWING_ZONE = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("peek"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target SAVE_BTN = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Modal Selector Button"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target CLOSE_BTN = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"NAME (A to Z)\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));



    @Override
    public void navigateToPageOnWeb(Actor theActor) {
        throw new IllegalArgumentException("Navigation not implemented");
    }

    @Override
    public void navigateToPageOnDevice(Actor theActor) {
        throw new IllegalArgumentException("Navigation not implemented");
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(DRAWING_HEADER, DRAWING_ZONE, SAVE_BTN,CLOSE_BTN));
        registerTheTopNavigation();
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfElementIsDisplayed(DRAWING_HEADER));
    }

    @Override
    public void registerTheTopNavigation() {
        TopNavigation.builder().build().configureTheComponent();
        super.pageElements.addAll(getComponentElements());
    }
}
