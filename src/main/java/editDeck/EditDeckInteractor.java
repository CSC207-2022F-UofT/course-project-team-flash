package editDeck;

import editCard.EditCardOutputBoundary;
import entities.Deck;

public class EditDeckInteractor  implements EditDeckInputBoundary {

    final EditDeckOutputBoundary editDeckOutputBoundary;

    public EditDeckInteractor(EditDeckOutputBoundary editDeckOutputBoundary) {
        this.editDeckOutputBoundary = editDeckOutputBoundary;
    }

    @Override
    public void edit(EditDeckInputData inputData) {
        Deck deck = Deck.getTracker().get(inputData.getDeckTracker());
        deck.setName(inputData.getName());

        EditDeckOutputData outputData = new EditDeckOutputData(deck, "Changes made succesfully!");
        editDeckOutputBoundary.prepareSuccessView(outputData);
    }
}
