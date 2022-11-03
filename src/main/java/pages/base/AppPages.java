package pages.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pages.app.DrawingPage;
import pages.app.HomePage;
import pages.app.LoginPage;
import pages.components.LeftNavigationPage;
import pages.components.TopNavigation;
import util.data.Constants;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@RequiredArgsConstructor
public enum AppPages {

    LOGIN_PAGE(getPages().getPage(LoginPage.class), Constants.LOGIN_PAGE),
    HOME_PAGE(getPages().getPage(HomePage.class), Constants.HOME_PAGE),
    DRAWING_PAGE(getPages().getPage(DrawingPage.class), Constants.DRAWING_PAGE),

    //The below are all component pages , havent added top navigation as it doesnt require explicit navigation
    LEFT_NAVIGATION_PAGE(getPages().getPage(LeftNavigationPage.class), Constants.LEFT_NAVIGATION_PAGE);




    @Getter
    private final BasePage page;
    @Getter
    private final String pageName;

    public static List<AppPages> getAllPages() {
        return new ArrayList<AppPages>(List.of(LOGIN_PAGE, HOME_PAGE,DRAWING_PAGE,LEFT_NAVIGATION_PAGE));
    }

    public static List<AppPages> getAllComponents() {
        return new ArrayList<AppPages>(List.of(LEFT_NAVIGATION_PAGE));
    }
}
