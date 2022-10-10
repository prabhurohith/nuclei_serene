package cast;

import model.data.ActorInfo;
import net.serenitybdd.screenplay.actors.OnStage;
import util.data.Constants;

import java.util.Optional;

public class TheCast {

    public static ActorInfo getActorInfo() {
        var actorInfo = Optional.ofNullable((ActorInfo) OnStage.theActorInTheSpotlight().recall(Constants.ACTOR_INFO));
        return actorInfo.get();
    }
}
