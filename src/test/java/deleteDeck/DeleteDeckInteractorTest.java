/*
 * Author: Aldo Bani
 * Date: November 27/22
 */

package deleteDeck;

import entities.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteDeckInteractorTest {
    @BeforeEach
    void createDeck(){
        Deck deckToDelete = new Deck("Test");
        Deck.addTracker(deckToDelete.getName(), deckToDelete);
    }
    @Test
    public void deleteDeck(){
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
}
