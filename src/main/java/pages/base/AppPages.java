package pages.base;

import org.jsoup.Connection;
import pages.HomePage;


public enum AppPages {
    HOME_PAGE {
        public BasePage getPage() {
            return new HomePage();
        }
    };
    public abstract BasePage getPage();
}
