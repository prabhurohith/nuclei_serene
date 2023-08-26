package util.data;

public class Constants {

    public static String ACTOR_INFO = "actor_info";
    public static String PET_INFO = "pet_info";
    public static String FOUND_PET_INFO = "found_pet_info";
    public static String RUN_PROFILE = "environment"; // Gets the run profile selected web , mobile web set using .conf files
    public static String RUN_ENVIRONMENT = "appEnvName"; // Gets the run profile selected web , mobile web set using .conf files
    public static String API_BASE_URL = "restapi.baseurl"; // Gets the run profile selected web , mobile web set using .conf files

    public static String ENABLE_LOGGING = "environments.api.service.enable.logging";


    //Page Constants
    public static String LOGIN_PAGE = "login";
    public static String HOME_PAGE = "home";
    public static String DRAWING_PAGE = "drawing";
    public static String DETAILS_PAGE = "details";

    public static String LEFT_NAVIGATION_PAGE = "left navigation";


    //App Constants
    public static String LEFT_NAVIGATION_OPENED = "is_left_nav_open";

    //mvn clean verify -Denvironment=firefox_web -Dwebdriver.base.url=https://www.saucedemo.com

    public enum ExecutionType {
        MOBILE,
        WEB,
        API;
    }


}
