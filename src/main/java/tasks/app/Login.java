package tasks.app;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import pages.app.LoginPage;

public class Login {

    public static Performable as(String userName, String userPwd) {
        return Task.where("{0} logs in as" + userName, Enter.theValue(userName).into(LoginPage.USERNAME_INPUT),
                Enter.theValue(userPwd).into(LoginPage.PWD_INPUT),
                Click.on(LoginPage.LOGIN_BTN).afterWaitingUntilEnabled());
    }


}
