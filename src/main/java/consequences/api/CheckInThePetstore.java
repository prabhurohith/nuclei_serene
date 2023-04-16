package consequences.api;

import model.data.api.request.CreatePet;
import model.data.api.response.CreatePetResponse;
import model.data.api.response.GetPetResponse;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class CheckInThePetstore {

    public static ArrayList<Consequence<?>> petDetailsAreDisplayedCorrectly(GetPetResponse actualPet, GetPetResponse petNameExpected) {
        return new ArrayList<>(List.of(
                seeThat(Question.about("Pet name verification").answeredBy(actor -> actualPet.getName().equals(petNameExpected.getName()))),
                seeThat(Question.about("Pet status verification").answeredBy(actor -> actualPet.getStatus().equals(petNameExpected.getStatus())))
        ));
    }

    public static ArrayList<Consequence<?>> petCreationIsSuccessful(CreatePetResponse petCreated,CreatePet petRequested) {
        return new ArrayList<>(List.of(
                seeThat(Question.about("Pet id verification").answeredBy(actor -> petCreated.getId().equals(petRequested.getId()))),
                seeThat(Question.about("Pet name verification").answeredBy(actor -> petCreated.getName().equals(petRequested.getName()))),
                seeThat(Question.about("Pet status verification").answeredBy(actor -> petCreated.getStatus().equals(petRequested.getStatus()))),
                seeThat(Question.about("Pet tag id verification").answeredBy(actor -> petCreated.getTags().get(0).getId().equals(petRequested.getTags().get(0).getId()))),
                seeThat(Question.about("Pet tag id verification").answeredBy(actor -> petCreated.getTags().get(0).getName().equals(petRequested.getTags().get(0).getName())))
        ));
    }


}
