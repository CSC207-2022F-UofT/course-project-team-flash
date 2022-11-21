package createDeck;

import createDeck.CreateDeckInputBoundary;
import createDeck.CreateDeckInputData;
import createDeck.CreateDeckOutputBoundary;
import createDeck.CreateDeckOutputData;
import entities.Deck;

/**
 * This file contains the implementation of the CreateDeckInteractor class,
 * which implements CreateDeckInputBoundary.
 */
public class CreateDeckInteractor implements CreateDeckInputBoundary {
    final CreateDeckOutputBoundary outputBoundary;

    /**
     * Constructor for the CreateDeckInteractor
     *
     * @param outputBoundary the output associated with this created deck
     */
    public CreateDeckInteractor(CreateDeckOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     *
     * @param inputData
     */
    @Override
    public void create(CreateDeckInputData inputData) {
        if (Deck.getTracker().containsKey(inputData.getName())){

            CreateDeckOutputData outputData = new CreateDeckOutputData("Deck name already exists!");
            outputBoundary.prepareFailView(outputData);
        }

        Deck newDeck = new Deck(inputData.getName());
        Deck.addTracker(inputData.getName(), newDeck);

        CreateDeckOutputData outputData = new CreateDeckOutputData("Deck created.");
        outputBoundary.prepareSuccessView(outputData);
    }
}
