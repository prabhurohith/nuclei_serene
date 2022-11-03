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
public class HomePage extends BasePage implements HasTopNavigation {


    public static Target PRODUCTS_HEADER = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("header_secondary_container"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target PEEK_PRODUCT_LOGO = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("peek"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart drop zone']/android.view.ViewGroup/android.widget.TextView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target SORT_FILTER = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Modal Selector Button"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target ASCENDING_NAME_SORT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"NAME (A to Z)\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target DESCENDING_NAME_SORT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"NAME (Z to A)\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target PRICE_FROM_LOW_SORT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Price (low to high)\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target PRICE_FROM_HIGH_SORT = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Price (high to low)\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target CANCEL_BTN = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Cancel\")"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target PRODUCT_TITLE = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title']"))
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
        super.pageElements.addAll(List.of(PRODUCTS_HEADER, PEEK_PRODUCT_LOGO, SORT_FILTER));
        registerTheTopNavigation();
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfElementIsDisplayed(PRODUCTS_HEADER));
    }

    @Override
    public void registerTheTopNavigation() {
        super.pageElements.addAll(getComponentElements());
    }
}
