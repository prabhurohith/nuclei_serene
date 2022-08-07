package pages.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pages.app.HomePage;
import pages.app.LoginPage;
import util.data.Constants;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

@RequiredArgsConstructor
public enum AppPages {

    LOGIN_PAGE(getPages().getPage(LoginPage.class), Constants.LOGIN_PAGE),
    HOME_PAGE(getPages().getPage(HomePage.class), Constants.HOME_PAGE);

    @Getter
    private final BasePage page;
    @Getter
    private final String pageName;

    public static List<AppPages> getAllPages() {
        return new ArrayList<AppPages>(List.of(LOGIN_PAGE, HOME_PAGE));
    }
}
