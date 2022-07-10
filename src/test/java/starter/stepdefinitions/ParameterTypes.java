package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import model.data.ActorInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import util.data.Constants;
import util.data.DataHandler;

import java.util.ArrayList;
import java.util.List;

public class ParameterTypes {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        Actor desiredActor = OnStage.theActorCalled(actorName);

        if (!new ArrayList<String>(List.of("he", "she", "him", "her")).contains(actorName)) {
            ActorInfo actorInfo =
                    new DataHandler().getActorInfo(actorName);
            desiredActor.remember(Constants.ACTOR_INFO, actorInfo);
        }
        return desiredActor;
    }




}
