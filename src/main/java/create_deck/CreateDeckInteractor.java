/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */
package create_deck;

import entities.Deck;

/**
 * Interactor that creates a Deck entity and stores it in memory
 */
public class CreateDeckInteractor implements CreateDeckInputBoundary {
    final CreateDeckOutputBoundary outputBoundary;

    public CreateDeckInteractor(CreateDeckOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Assigns a success or fail value to an instance of CreateDeckOutputData.
     *
     * @param inputData input data
     */
    @Override
    public void create(CreateDeckInputData inputData) {
        if (Deck.getTracker().containsKey(inputData.getName())){
            CreateDeckOutputData outputData = new CreateDeckOutputData(
                    "Deck name already exists. Please choose a different name.");
            outputBoundary.prepareFailView(outputData);
        }
        else {
            Deck newDeck = new Deck(inputData.getName());
            Deck.addTracker(inputData.getName(), newDeck);

            CreateDeckOutputData outputData = new CreateDeckOutputData(inputData.getName());
            outputBoundary.prepareSuccessView(outputData);
        }
    }
}
