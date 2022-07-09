package pages.base;

import pages.app.LoginPage;


public enum AppPages {
    HOME_PAGE {
        public BasePage getPage() {
            return new LoginPage();
        }
    };
    public abstract BasePage getPage();
}
