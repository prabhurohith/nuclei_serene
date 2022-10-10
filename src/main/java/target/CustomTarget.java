package target;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import questions.EnvironmentInfo;

public class CustomTarget {
// Get chaining in static methods

    //Name
    String targetName;

    //Web
    By locator;
    //Device
    By androidLocator;
    Target deviceTarget;

    public CustomTarget namedAs(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public CustomTarget locatedOnWebBy(By locator) {
        this.locator = locator;
        return this;
    }

    public CustomTarget locatedOnAndroidBy(By androidLocator) {
        this.androidLocator = androidLocator;
        return this;
    }

    public Target locatedOnIOSBy(By iosLocator) {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("web")) {
            return Target.the(targetName).located(locator);
        } else {
            return Target.the(targetName).locatedForAndroid(androidLocator).locatedForIOS(iosLocator);
        }
    }

}
