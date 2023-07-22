package model.api.request;

import lombok.Builder;
import lombok.Data;
import model.api.request.common.Category;
import model.api.request.common.Tags;
import net.serenitybdd.screenplay.Actor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class EditPetRequest {
    private List<String> photoUrls;
    private String name;
    private Integer id;
    private Category category;
    private List<Tags> tags;
    private String status;

    public static EditPetRequest asServiceRequest(Actor theActor) {
        return EditPetRequest.builder()
                .name(theActor.recall("petName"))
                .id(theActor.recall("petId"))
                .tags(List.of(Tags.builder()
                        .name(theActor.recall("tagName"))
                        .id(theActor.recall("tagId"))
                        .build()
                ))
                .photoUrls(new ArrayList<>())
                .status(theActor.recall("status"))
                .build();
    }
}
