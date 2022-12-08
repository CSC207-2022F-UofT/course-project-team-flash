/*
 * Author: Aldo Bani
 * Date: November 27/22
 */

package delete_deck;

import entities.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteDeckInteractorTest {
    @Test
    public void deleteSingleDeck(){
        Deck deckToDelete = new Deck("Test");
        Deck.addTracker(deckToDelete.getName(), deckToDelete);
        DeleteDeckOutputBoundary presenter = new DeleteDeckPresenter(null){
            @Override
            public void prepareSuccessView(DeleteDeckOutputData outputData) {
                Assertions.assertNull(Deck.getTracker().get("Test"));
            }
            @Override
            public void prepareFailView(String exception) {
                Assertions.fail(exception);
            }
        };
        DeleteDeckInputBoundary interactor = new DeleteDeckInteractor(presenter);
        DeleteDeckInputData inputData = new DeleteDeckInputData("Test");
        interactor.delete(inputData);
    }

    @Test
    public void deleteNonExistingDeck(){
        DeleteDeckOutputBoundary presenter = new DeleteDeckPresenter(null){
            @Override
            public void prepareSuccessView(DeleteDeckOutputData outputData) {
                Assertions.fail("Should not be able to delete anything.");
            }
            @Override
            public void prepareFailView(String exception) {
                Assertions.assertEquals("Deck not found", exception);
            }
        };
        DeleteDeckInputBoundary interactor = new DeleteDeckInteractor(presenter);
        DeleteDeckInputData inputData = new DeleteDeckInputData("Test");
        interactor.delete(inputData);
    }
}
