package util.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.data.ActorInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataHandler {

    public ActorInfo getActorInfo(String actorName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ActorInfo> actorsData = objectMapper.readValue(
                    new File("./src/test/resources/data/actors/ActorInfo.json"),
                    new TypeReference<List<ActorInfo>>() {
                    });
            return actorsData.stream().filter(actorInfo -> actorInfo.getName().equalsIgnoreCase(actorName)).findFirst().get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
