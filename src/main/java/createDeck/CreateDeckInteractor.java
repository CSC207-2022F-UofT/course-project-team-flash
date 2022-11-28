/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */
package createDeck;

import createDeck.CreateDeckInputBoundary;
import createDeck.CreateDeckInputData;
import createDeck.CreateDeckOutputBoundary;
import createDeck.CreateDeckOutputData;
import entities.Deck;

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
        System.out.println(Deck.getTracker().containsKey(inputData.getName()));
        if (Deck.getTracker().containsKey(inputData.getName())){
            CreateDeckOutputData outputData = new CreateDeckOutputData("Deck name already exists!");
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
