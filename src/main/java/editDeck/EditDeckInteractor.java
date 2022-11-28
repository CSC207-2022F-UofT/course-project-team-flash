package editDeck;

import editCard.EditCardOutputBoundary;
import entities.Deck;

import java.util.Map;

public class EditDeckInteractor  implements EditDeckInputBoundary {

    final EditDeckOutputBoundary editDeckOutputBoundary;

    public EditDeckInteractor(EditDeckOutputBoundary editDeckOutputBoundary) {
        this.editDeckOutputBoundary = editDeckOutputBoundary;
    }

    @Override
    public void edit(EditDeckInputData inputData) {
        Map<String, Deck> tracker = Deck.getTracker();
        Deck deck = tracker.get(inputData.getoldName());
        if (Deck.getTracker().containsKey(inputData.getnewName())) {
            EditDeckOutputData outputData = new EditDeckOutputData(deck, "Deck name already exists. Please choose a different name.");
            editDeckOutputBoundary.prepareFailView(outputData);
        } else {
            deck.setName(inputData.getnewName());

            Deck.removeTracker(inputData.getoldName());
            Deck.addTracker(inputData.getnewName(), deck);

            EditDeckOutputData outputData = new EditDeckOutputData(deck, "Changes made succesfully!");
            editDeckOutputBoundary.prepareSuccessView(outputData);
        }

    }
}
