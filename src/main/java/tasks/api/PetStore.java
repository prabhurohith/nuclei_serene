package tasks.api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.data.api.request.CreatePet;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public class PetStore {

    public static Performable getThePet(int petId) {
        return Task.where(Get.resource("/v2/pet/" + petId));
    }


    public static Performable addThePet(CreatePet desiredPet) {
        return Task.where(Post.to("/v2/pet")
                .with(requestSpecification -> requestSpecification
                        .headers(desiredPet.getHeaders())
                        .body(desiredPet)
                )
        );
    }

}
