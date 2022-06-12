package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.data.ActorInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestData {

    public static void main(String[] args) {
         ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ActorInfo> actorsData = objectMapper.readValue(
                    new File("./src/test/resources/data/actors/ActorInfo.json"),
                    new TypeReference<List<ActorInfo>>(){});
            ActorInfo desiredActor = actorsData.stream().filter(actorInfo -> actorInfo.getName().contains("Jack")).findFirst().get();
            desiredActor.getDescription();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
