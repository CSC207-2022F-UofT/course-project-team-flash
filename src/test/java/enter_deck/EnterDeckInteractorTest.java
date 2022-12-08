package enter_deck;

import entities.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void enteringDeckWithTwoCards() {
        String deckName = "EnterDeckTest3";
        Deck deck = new Deck(deckName);
        Deck.addTracker(deckName, deck);

        QandAFlashcard flashcard1 = new QandAFlashcard("question1", "answer");
        MCFlashcard flashcard2 = new MCFlashcard("question2", "answer", new ArrayList<>());

        Flashcard.addTracker(flashcard1.getUniqueID(), flashcard1);
        Flashcard.addTracker(flashcard2.getUniqueID(), flashcard2);

        deck.addCard(flashcard1);
        deck.addCard(flashcard2);
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

    @AfterAll
    public static void tearDown() {
        Flashcard.getTracker().clear();
        Deck.getTracker().clear();
    }
}