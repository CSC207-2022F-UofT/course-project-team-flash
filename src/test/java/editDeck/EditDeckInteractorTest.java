package editDeck;

import entities.Deck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EditDeckInteractorTest {
    @Test
    public void editDeck(){
        Deck deckToEdit = new Deck("Test");
        Deck.addTracker(deckToEdit.getName(), deckToEdit);
        EditDeckOutputBoundary presenter = new EditDeckPresenter(null){
            @Override
            public void prepareSuccessView(EditDeckOutputData outputData) {
                Assertions.assertNull(Deck.getTracker().get("Test"));
                Assertions.assertEquals("Examination", Deck.getTracker().get("Examination").getName());
            }
            @Override
            public void prepareFailView(EditDeckOutputData outputData) {
                Assertions.fail(outputData.getText());
            }
        };
        EditDeckInputBoundary interactor = new EditDeckInteractor(presenter);
        EditDeckInputData inputData = new EditDeckInputData("Test", "Examination");
        interactor.edit(inputData);
    }

    @Test
    public void editNonExistingDeck(){
        EditDeckOutputBoundary presenter = new EditDeckPresenter(null){
            @Override
            public void prepareSuccessView(EditDeckOutputData outputData) {
                Assertions.fail("Should not be able to edit nothing!");
            }
            @Override
            public void prepareFailView(EditDeckOutputData outputData) {
                Assertions.assertEquals("Deck does not exist!", outputData.getText());
            }
        };
        EditDeckInputBoundary interactor = new EditDeckInteractor(presenter);
        EditDeckInputData inputData = new EditDeckInputData("Test", "Examination");
        interactor.edit(inputData);
    }
}
