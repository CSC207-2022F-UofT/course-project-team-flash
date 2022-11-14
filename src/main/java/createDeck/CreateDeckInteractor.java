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
