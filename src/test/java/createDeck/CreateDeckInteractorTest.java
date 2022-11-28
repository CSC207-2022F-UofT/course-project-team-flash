/*
 * Author: Aldo Bani
 * Date: November 27/22
 */

package createDeck;

import entities.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateDeckInteractorTest {
    @Test
    public void createDeck(){
        CreateDeckOutputBoundary presenter = new CreateDeckPresenter(null) {
            @Override
            public void prepareSuccessView(CreateDeckOutputData outputData) {
                Assertions.assertEquals("Test", Deck.getTracker().get("Test").getName());
            }

            @Override
            public void prepareFailView(CreateDeckOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }
        };
        CreateDeckInputBoundary interactor = new CreateDeckInteractor(presenter);
        CreateDeckInputData inputData = new CreateDeckInputData("Test");
        interactor.create(inputData);
    }
    /*
    @Test
    public void createDupeDeck(){
        Deck deckToDelete = new Deck("Test");
        Deck.addTracker(deckToDelete.getName(), deckToDelete);
        CreateDeckOutputBoundary presenter = new CreateDeckPresenter(null){
            @Override
            public void prepareSuccessView(CreateDeckOutputData outputData) {

            }
            @Override
            public void prepareFailView(CreateDeckOutputData outputData) {

            }
        };
        CreateDeckInputBoundary interactor = new CreateDeckInteractor(presenter);
        CreateDeckInputData inputData = new CreateDeckInputData("Test");
        interactor.create(inputData);
    }*/
}