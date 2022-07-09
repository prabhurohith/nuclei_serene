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

}
