package tasks.api;

import model.api.request.CreatePetRequest;
import model.api.request.EditPetRequest;
import model.api.request.RequestHeaders;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import util.api.RequestHandler;
import util.data.UrlEndpoints;

public class PetStore {

    public static Performable getThePet(int petId) {
        return Task.where(Get.resource("/v2/pet/" + petId));
    }

    public static Performable addThePet(CreatePetRequest desiredPet) {
        return Task.where(Post.to(UrlEndpoints.createPet)
                .with(requestSpecification -> RequestHandler.enableLoggingIfRequired(requestSpecification
                        .headers(RequestHeaders.getHeadersForCreatePet())
                        .body(desiredPet))
                )
        );
    }

    public static Performable editThePetDetails(EditPetRequest editedPetDetails) {
        return Task.where(Put.to(UrlEndpoints.editPet)
                .with(requestSpecification -> RequestHandler.enableLoggingIfRequired(requestSpecification
                        .headers(RequestHeaders.getHeadersForCreatePet())
                        .body(editedPetDetails))
                )
        );
    }

}
