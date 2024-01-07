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
import target.CustomTarget;

import java.util.List;

@DefaultUrl("page:details.page")
public class DetailsPage extends BasePage implements HasTopNavigation {


    public static Target BACK_TO_PRODUCTS_HEADER = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.className("header_secondary_container"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-BACK TO PRODUCTS"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));


    public static Target PRODUCT_IMAGE = new CustomTarget().namedAs("Product Image")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Image Container']/android.widget.ImageView"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target PRODUCT_TITLE = new CustomTarget().namedAs("Product Title")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));


    public static Target PRODUCT_PRICE = new CustomTarget().namedAs("PRODUCT PRICE")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Price)"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target ADD_TO_CART = new CustomTarget().namedAs("Add To Cart")
            .locatedOnWebBy(By.className("right_component"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-ADD TO CART"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));



    @Override
    public void navigateToPageOnWeb(Actor theActor) {
        throw new IllegalArgumentException("Navigation not present");
    }

    @Override
    public void navigateToPageOnDevice(Actor theActor) {
        throw new IllegalArgumentException("Navigation not present");
    }

    @Override
    public BasePage registerPageElements() {
        super.pageElements.addAll(List.of(BACK_TO_PRODUCTS_HEADER, PRODUCT_IMAGE, PRODUCT_TITLE));
        registerTheTopNavigation();
        return this;
    }

    @Override
    public void checkIfThePageIsLoaded() {
        OnStage.theActorInTheSpotlight().should(PageConsequences.checkIfElementIsDisplayed(BACK_TO_PRODUCTS_HEADER));
    }

    @Override
    public void registerTheTopNavigation() {
        super.pageElements.addAll(getComponentElements());
    }
}
