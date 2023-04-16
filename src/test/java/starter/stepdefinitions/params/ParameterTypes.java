package starter.stepdefinitions.params;

import io.cucumber.java.ParameterType;
import model.data.user.ActorInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.EnvironmentInfo;
import util.data.Constants;
import util.data.DataHandler;

import java.util.ArrayList;
import java.util.List;

public class ParameterTypes {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        Actor desiredActor = OnStage.theActorCalled(actorName);
        //If any specific actor is specified then it picks that up else excludes tehn pronouns
        if (!new ArrayList<String>(List.of("he", "she", "him", "her", "I")).contains(actorName)) {
            ActorInfo actorInfo =
                    new DataHandler().getActorInfo(actorName);
            desiredActor.remember(Constants.ACTOR_INFO, actorInfo);
        }
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("api")) {
            //Move this to property based
            String theRestApiBaseUrl = EnvironmentInfo.getBaseApiUrl();
//            String theRestApiBaseUrl = "https://petstore.swagger.io";
            desiredActor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        }
        return desiredActor;
    }


}
