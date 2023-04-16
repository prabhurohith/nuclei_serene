package model.data.api.request;

import io.restassured.http.ContentType;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class CreatePet {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;

    @Data
    public class Category {
        private String name;
        private Integer id;
    }

    @Data
    @Builder
    public static class Tags {
        private String name;
        private Integer id;
    }

    public Map<String, Object> getHeaders() {
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("accept", ContentType.JSON);
        requestHeaders.put("Content-Type", ContentType.JSON);
        return requestHeaders;
    }


    public static CreatePet asServiceRequest(Actor theActor) {
        return CreatePet.builder()
                .name(theActor.recall("petName"))
                .id(theActor.recall("petId"))
                .tags(List.of(CreatePet.Tags.builder()
                        .name(theActor.recall("tagName"))
                        .id(theActor.recall("tagId"))
                        .build()
                ))
                .photoUrls(new ArrayList<>())
                .status(theActor.recall("status"))
                .build();
    }

}
