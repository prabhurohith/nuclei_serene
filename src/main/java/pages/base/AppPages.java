package pages.base;

import pages.app.HomePage;
import pages.app.LoginPage;
import util.data.Constants;

import java.util.ArrayList;
import java.util.List;


public enum AppPages {

    LOGIN_PAGE {
        public BasePage getPage() {
            return new LoginPage();
        }

        @Override
        public String getPageName() {
            return Constants.LOGIN_PAGE;
        }
    },
    HOME_PAGE {
        public BasePage getPage() {
            return new HomePage();
        }

        @Override
        public String getPageName() {
            return Constants.HOME_PAGE;
        }
    };

    public abstract BasePage getPage();

    public abstract String getPageName();

    public static List<AppPages> getAllPages() {
        return new ArrayList<AppPages>(List.of(LOGIN_PAGE, HOME_PAGE));
    }
}
