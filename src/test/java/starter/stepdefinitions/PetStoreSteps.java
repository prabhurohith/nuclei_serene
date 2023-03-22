package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import model.data.api.Pet;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;


public class PetStoreSteps extends UIInteractions {
    @Given("{string} is available in the pet store")
    public void is_available_in_the_pet_store(String string) {
    }

    @When("I ask for a pet using id as {int}")
    public void i_ask_for_a_pet_using_id_as(Integer int1) {
        Pet pet = new Pet("CatTest", "available");
        SerenityRest.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .accept(ContentType.JSON)
                .when()
                .get("/" + int1);
    }

    @Then("I get {string} as result")
    public void i_get_as_result(String petName) {
        then().body("name", Matchers.equalTo(petName));
    }
}
