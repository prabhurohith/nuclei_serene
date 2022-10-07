package questions;

import util.data.Constants;

public class EnvironmentInfo {

    public static String getRunProfile() {
        String platformName = System.getProperty(Constants.RUN_PROFILE);
        return platformName;
    }

    public static String getAppEnvironment() {
        return System.getProperty(Constants.RUN_ENVIRONMENT);
    }

    // Gets the type of platform execution

    public static Constants.ExecutionType getExecutionType() {
        switch (getRunProfile()) {
            case "chrome_web":
            case "firefox_web":
                return Constants.ExecutionType.WEB;
            case "android_device":
            case "ios_device":
                return Constants.ExecutionType.MOBILE;
            default:
                throw new IllegalArgumentException("Please select a valid env");

        }
    }

}
