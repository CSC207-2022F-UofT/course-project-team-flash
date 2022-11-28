package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

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
        System.out.println(tracker.containsKey(inputData.getoldName()));
        if (!(tracker.containsKey(inputData.getoldName()))) {
            EditDeckOutputData outputData = new EditDeckOutputData("Deck does not exist!");
            editDeckOutputBoundary.prepareFailView(outputData);
        }
        else if (tracker.containsKey(inputData.getnewName())) {
            EditDeckOutputData outputData = new EditDeckOutputData("Deck name already exists. Please choose a different name.");
            editDeckOutputBoundary.prepareFailView(outputData);
        }
        else {
            Deck deck = tracker.get(inputData.getoldName());
            deck.setName(inputData.getnewName());

            Deck.removeTracker(inputData.getoldName());
            Deck.addTracker(inputData.getnewName(), deck);

            EditDeckOutputData outputData = new EditDeckOutputData(deck.getName());
            editDeckOutputBoundary.prepareSuccessView(outputData);
        }

    }
}
