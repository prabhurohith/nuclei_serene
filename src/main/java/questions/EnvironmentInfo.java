package questions;

import net.serenitybdd.screenplay.Question;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import util.data.Constants;

public class EnvironmentInfo {

    public static String getRunProfile() {
        String platformName = System.getProperty(Constants.RUN_PROFILE);
        return platformName;
    }

    public static String getAppEnvironment() {
        return System.getProperty(Constants.RUN_ENVIRONMENT);
    }

    public static String getBaseApiUrl() {
        return System.getProperty(Constants.API_BASE_URL);
    }

    // Gets the type of platform execution

    public static Constants.ExecutionType getExecutionType() {
        switch (getRunProfile()) {
            case "chrome_web":
            case "firefox_web":
                return Constants.ExecutionType.WEB;
            case "android_device":
            case "android_farm_device":
            case "ios_farm_device":
            case "ios_device":
                return Constants.ExecutionType.MOBILE;
            case "API":
                return Constants.ExecutionType.API;
            default:
                throw new IllegalArgumentException("Please select a valid env");

        }
    }

    public static Question<String> theCurrentExectuionType()
    {
        return Question.about("The Execution Type").answeredBy(actor -> getExecutionType().name());
    }
    //This is to take a property from serenity config
    public static Boolean isLoggingEnabled() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        variables.getProperty(Constants.ENABLE_LOGGING);
        return Boolean.valueOf(variables.getProperty(Constants.ENABLE_LOGGING));
    }
}
