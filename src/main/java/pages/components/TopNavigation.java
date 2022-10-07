package pages.components;

import io.appium.java_client.AppiumBy;
import lombok.Builder;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageFactory;
import org.openqa.selenium.By;
import target.CustomTarget;

import java.util.List;

@Builder
@Getter
public class TopNavigation extends PageObject implements IsComponent {


    public static Target LEFT_MENU_BTN = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("react-burger-menu-btn"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Menu"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target APP_LOGO = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("app_logo"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Cart"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public static Target SHOPPING_CART = new CustomTarget().namedAs("TargetName")
            .locatedOnWebBy(By.id("shopping_cart_container"))
            .locatedOnAndroidBy(AppiumBy.accessibilityId("test-Cart"))
            .locatedOnIOSBy(AppiumBy.id("test-Username"));

    public void configureTheComponent() {
        new PageFactory(Serenity.getDriver()).createPageOfType(TopNavigation.class);
    }


    public static List<Target> getComponentElements() {
        return List.of(LEFT_MENU_BTN, APP_LOGO, SHOPPING_CART);
    }


}
