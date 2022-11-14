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
        Deck newDeck = new Deck(inputData.getName());

        CreateDeckOutputData outputData = new CreateDeckOutputData("Deck created.");
        outputBoundary.prepareSuccessView(outputData);
    }
}
