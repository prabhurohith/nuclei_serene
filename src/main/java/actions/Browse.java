package actions;

import com.google.common.collect.Iterables;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import questions.app.HomePageInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Browse implements Performable {

    private final Target desiredElement;
    private final String elementValue;
    private final Target elementToScroll;
    Browse(Target desiredElement, String elementValue, Target elementToScroll)
    {
        this.desiredElement = desiredElement;
        this.elementValue= elementValue;
        this.elementToScroll = elementToScroll;
    }

    public static Browse forProducts(Target desiredElement, String elementValue, Target elementToScroll)
    {
        return new Browse(desiredElement,elementValue,elementToScroll);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int scrollCntVal =10;
        List<Integer> cardsHeight = new ArrayList<>();
        elementToScroll.resolveAllFor(actor).forEach(indElement->cardsHeight.add(indElement.getRect().getHeight()));
        cardsHeight.sort(Comparator.reverseOrder());
        int sizeOfCard = cardsHeight.get(0);
        ELEME_FOUND:for(int cntVal=0;cntVal<scrollCntVal;cntVal++)
        {
            for(WebElementFacade indElement:desiredElement.resolveAllFor(actor))
            {
                System.out.println("Scroll cnt "+cntVal);
                if(indElement.getText().equalsIgnoreCase(elementValue))
                {
                    System.out.println("Element found ");
                    actor.remember("elementForAction",indElement);
                    break ELEME_FOUND;
                }
            }
            WebElementFacade desiredElemeToScroll = elementToScroll.resolveAllFor(actor)
                    .stream()
                    .max(Comparator.comparingInt(customObject -> customObject.getRect().getHeight()))
                            .orElse(null);
            actor.attemptsTo(Scroll.swipeDownAcrossElement(desiredElemeToScroll));
        }
        System.out.println("Teh recalled element "+actor.recall("elementForAction"));
    }
}
