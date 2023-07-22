package starter.stepdefinitions.api;

import consequences.api.CheckInThePetstore;
import consequences.api.CheckResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.api.request.CreatePetRequest;
import model.api.request.EditPetRequest;
import model.api.response.CreatePetResponse;
import model.api.response.EditPetResponse;
import model.api.response.GetPetResponse;
import model.api.response.PetError;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.api.PetStore;
import util.data.Constants;
import util.data.DataHandler;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class PetStoreSteps {
    private  CreatePetResponse createPetResponseShared;

    @When("I ask for a pet using id as {int}")
    public GetPetResponse getPetInfoUsingPetId(Integer petId) {
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.getThePet(petId));
        GetPetResponse actualPet = SerenityRest.lastResponse().as(GetPetResponse.class);
        OnStage.theActorInTheSpotlight().remember(Constants.FOUND_PET_INFO, actualPet);
        return actualPet;
    }


    @Then("I get {word} as result")
    public void i_get_as_result(String petName) {
        GetPetResponse actualPet = SerenityRest.lastResponse().as(GetPetResponse.class);
        GetPetResponse expPet = OnStage.theActorInTheSpotlight().recall(Constants.PET_INFO);
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.petDetailsAreDisplayedCorrectly(actualPet, expPet));
    }

    @Then("I get as pet not found")
    public void i_get_as_pet_not_found() {
        PetError errorMsg = SerenityRest.lastResponse().as(PetError.class);
        assertThat(errorMsg.getMessage()).isEqualTo("Pet not found");
    }

    @Given("{actor} wants to search for {word} in the pet store")
    public void marleyWantsToSearchForDoggieInThePetStore(Actor theActor, String petName) {
        // Init the pet name for API
        GetPetResponse petInfo =
                new DataHandler().getPetInfo(petName);
        theActor.remember(Constants.PET_INFO, petInfo);
    }

    @Given("{actor} wants to add a pet in the pet store")
    @Given("{actor} wants to edit a pet in the pet store")
    public void marleyWantsToAddAPetInThePetStore(Actor theActor) {
    }

    @And("names the pet as {string} with a id as {int}")
    public void namesThePetAsDogzillaWithAUniqueID(String petName, int petId) {
        OnStage.theActorInTheSpotlight().remember("petName", petName);
        OnStage.theActorInTheSpotlight().remember("petId", petId);
    }

    @And("tags it as a {string} with id as {int}")
    public void tagsItAsADogWithIdAs(String tagName, int tagId) {
        OnStage.theActorInTheSpotlight().remember("tagName", tagName);
        OnStage.theActorInTheSpotlight().remember("tagId", tagId);
    }

    @And("makes it available for adoption")
    public void isAvailableForAdoption() {
        OnStage.theActorInTheSpotlight().remember("status", "available");
    }

    @When("he adds the pet")
    public void heAddsThePet() {
        CreatePetRequest desiredPet = CreatePetRequest.asServiceRequest(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().remember("createdPet", desiredPet);
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.addThePet(desiredPet));
    }

    @Then("he should see that the pet is added successfully")
    public void heShouldSeeThatThePetIsAddedSuccessfully() {
        CreatePetRequest petDesired = OnStage.theActorInTheSpotlight().recall("createdPet");
        OnStage.theActorInTheSpotlight().should(CheckResponse.forSuccessfulCreation());
        CreatePetResponse createPetResponse = SerenityRest.lastResponse()
                .as(CreatePetResponse.class);
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.petCreationIsSuccessful(createPetResponse, petDesired));
    }

    @And("he remembers the pet created")
    public void heRemembersThePetCreated() {
        //Rember the created PET info here , actor.remember works ehen in same scenario
        createPetResponseShared = SerenityRest.lastResponse()
                .as(CreatePetResponse.class);
    }

    @And("changes the pet name to {string}")
    public void changesThePetNameToDogzilla(String desiredPetName) {
        OnStage.theActorInTheSpotlight().remember("petName", desiredPetName);
        OnStage.theActorInTheSpotlight().remember("petId", createPetResponseShared.getId());
        OnStage.theActorInTheSpotlight().remember("tagName", createPetResponseShared.getTags().get(0).getName());
        OnStage.theActorInTheSpotlight().remember("tagId", createPetResponseShared.getTags().get(0).getId());
        OnStage.theActorInTheSpotlight().remember("status", createPetResponseShared.getStatus());
        // Edit Pet Request
        EditPetRequest desiredPet = EditPetRequest.asServiceRequest(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.editThePetDetails(desiredPet));
        OnStage.theActorInTheSpotlight().remember("editedPet", desiredPet);
    }

    @Then("he should see that the pet is edited successfully")
    public void heShouldSeeThatThePetIsEditedSuccessfully() {
        //Edit pet response
        EditPetRequest editedPet = OnStage.theActorInTheSpotlight().recall("editedPet");
        OnStage.theActorInTheSpotlight().should(CheckResponse.forSuccessfulCreation());
        EditPetResponse editPetResponse = SerenityRest.lastResponse()
                .as(EditPetResponse.class);
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.editPetIsSuccessful(editPetResponse, editedPet));
    }

    @And("change the name of the pet")
    public void changeTheNameOfThePet() {
        GetPetResponse expPet = OnStage.theActorInTheSpotlight().recall(Constants.FOUND_PET_INFO);
        OnStage.theActorInTheSpotlight().remember("petName", "Shanuza");
        OnStage.theActorInTheSpotlight().remember("petId", expPet.getId());
        OnStage.theActorInTheSpotlight().remember("tagName", expPet.getTags().get(0).getName());
        OnStage.theActorInTheSpotlight().remember("tagId", expPet.getTags().get(0).getId());
        OnStage.theActorInTheSpotlight().remember("status", expPet.getStatus());
        // Edit Pet Request
        EditPetRequest desiredPet = EditPetRequest.asServiceRequest(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.editThePetDetails(desiredPet));
        OnStage.theActorInTheSpotlight().remember("editedPet", desiredPet);
    }



    @Then("he should see that the changes made to pet in the store are successful")
    public void heShouldSeeThatTheChangesMadeToPetInTheStoreAreSuccessful() {
        EditPetRequest editedPet = OnStage.theActorInTheSpotlight().recall("editedPet");
        OnStage.theActorInTheSpotlight().should(CheckResponse.forSuccessfulCreation());
        EditPetResponse editPetResponse = SerenityRest.lastResponse()
                .as(EditPetResponse.class);
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.editPetIsSuccessful(editPetResponse, editedPet));
    }


    @And("he is able to fetch the pet details using the new name")
    public void heIsAbleToFetchThePetDetailsUsingTheNewName() {
        GetPetResponse expPet = OnStage.theActorInTheSpotlight().recall(Constants.FOUND_PET_INFO);
        EditPetRequest editedPet = OnStage.theActorInTheSpotlight().recall("editedPet");
        GetPetResponse actualPet = getPetInfoUsingPetId(editedPet.getId());
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.petDetailsAreDisplayedCorrectly(actualPet, expPet));
    }
}
