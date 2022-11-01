package starter.stepdefinitions;

import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import pages.app.DrawingPage;
import questions.EnvironmentInfo;
import util.data.Constants;

public class DrawingPageSteps {
    @And("{actor} is able to save the drawing after recording it")
    public void heIsAbleToSaveTheDrawingAfterRecordingIt(Actor actor) {
        /**
         * This is just to showcase the branching on tasks
         */
        actor.attemptsTo (
                Check.whether(EnvironmentInfo.theCurrentExectuionType().equals(Constants.ExecutionType.MOBILE))
                        .andIfSo(Click.on(DrawingPage.SAVE_BTN))
                        .otherwise()
        );
    }
}
