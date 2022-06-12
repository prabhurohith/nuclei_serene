package questions;

public class EnvironmentInfo {

    public static String getPlatformName()
    {
        String platformName = System.getProperty("environment");
        return platformName;
    }
}
