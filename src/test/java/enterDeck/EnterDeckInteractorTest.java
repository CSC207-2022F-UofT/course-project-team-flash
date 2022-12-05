package enterDeck;

import entities.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnterDeckInteractorTest {
    @Test
    public void enteringADeck(){
        String deckName = "EnterDeckTest1";
        Deck deck = new Deck(deckName);
        Deck.addTracker(deckName, deck);
        EnterDeckOutputBoundary presenter = new EnterDeckPresenter(null){
            @Override
            public void prepareSuccessView(EnterDeckOutputData outputData) {
                Assertions.assertNotNull(outputData.getCardInfo());
            }
            @Override
            public void prepareFailView(String exception) {
                Assertions.fail(exception);
            }
        };
        EnterDeckInputBoundary interactor = new EnterDeckInteractor(presenter);
        EnterDeckInputData inputData = new EnterDeckInputData(deckName);
        interactor.enter(inputData);
    }

    @Test
    public void enteringNonExistingDeck() {
        String deckName = "EnterDeckTest2";
        EnterDeckOutputBoundary presenter = new EnterDeckPresenter(null){
            @Override
            public void prepareSuccessView(EnterDeckOutputData outputData) {
                Assertions.fail("Should not be able to enter nothing!");
            }
            @Override
            public void prepareFailView(String exception) {
                Assertions.assertEquals("Could not enter, as the deck does not exist!", exception);
            }
        };
        EnterDeckInputBoundary interactor = new EnterDeckInteractor(presenter);
        EnterDeckInputData inputData = new EnterDeckInputData(deckName);
        interactor.enter(inputData);
    }
}
