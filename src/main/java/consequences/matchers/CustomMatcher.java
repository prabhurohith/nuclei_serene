package consequences.matchers;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import questions.EnvironmentInfo;
import util.data.Constants;

public class CustomMatcher {


    public static <T extends WebElementState> TypeSafeMatcher<T> containsAttribute(String attributeTag, String expectedText) {
        //This method checks for attribute
        return new TextMatcher<T>(attributeTag, expectedText);
    }

    public static <T extends WebElementState> TypeSafeMatcher<T> containsText(String expectedText) {
        //This method fetches textContent for web and text for device
        if (EnvironmentInfo.getExecutionType() == Constants.ExecutionType.MOBILE) {
            return new TextMatcher<T>("text", expectedText);
        } else
            return new TextMatcher<T>("textContent", expectedText);
    }

    public static class TextMatcher<T extends WebElementState> extends TypeSafeMatcher<T> {
        private final String attributeTag;
        private final String expectedText;

        public TextMatcher(String attributeTag, String expectedText) {
            this.expectedText = expectedText;
            this.attributeTag = attributeTag;
        }

        @Override
        protected boolean matchesSafely(T desiredTarget) {
            String attributeVal = desiredTarget.getAttribute(attributeTag);
            return expectedText.contains(attributeVal);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("an element containing '").appendText(expectedText).appendText("'");
        }
    }


}
