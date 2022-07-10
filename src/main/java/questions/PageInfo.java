package questions;

import net.serenitybdd.screenplay.Question;
import pages.base.AppPages;
import pages.base.BasePage;

import java.util.Optional;

public class PageInfo {

    public static Question<Optional<BasePage>> getDesiredPage(String pageName)
    {
        Optional<BasePage> desiredPage = Optional
                .ofNullable(AppPages.getAllPages().stream().filter(indPage -> indPage.getPageName().equalsIgnoreCase(pageName)).findFirst().get().getPage());
        return Question.about("The current Page").answeredBy(actor -> desiredPage);
    }
}
