package starter.stepdefinitions.api;

import consequences.api.CheckInThePetstore;
import consequences.api.CheckResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.data.api.request.CreatePet;
import model.data.api.response.CreatePetResponse;
import model.data.api.response.GetPetResponse;
import model.data.api.response.PetError;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.api.PetStore;
import util.data.Constants;
import util.data.DataHandler;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class PetStoreSteps {


    @When("I ask for a pet using id as {int}")
    public void i_ask_for_a_pet_using_id_as(Integer petId) {
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.getThePet(petId));
    }


    @Then("I get {string} as result")
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
        CreatePet desiredPet = CreatePet.asServiceRequest(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().remember("createdPet", desiredPet);
        OnStage.theActorInTheSpotlight().attemptsTo(PetStore.addThePet(desiredPet));
    }

    @Then("he should see that the pet is added successfully")
    public void heShouldSeeThatThePetIsAddedSuccessfully() {
        CreatePet petDesired = OnStage.theActorInTheSpotlight().recall("createdPet");
        OnStage.theActorInTheSpotlight().should(CheckResponse.forSuccessfulCreation());
        CreatePetResponse createPetResponse = SerenityRest.lastResponse()
                .as(CreatePetResponse.class);
        OnStage.theActorInTheSpotlight().should(CheckInThePetstore.petCreationIsSuccessful(createPetResponse, petDesired));
    }
}
