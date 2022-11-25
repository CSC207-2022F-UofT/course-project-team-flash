package createDeck;

/**
 * This file contains an interface named CreateDeckOutputBoundary.
 * It has two abstract methods named prepareSuccessView and prepareFailView.
 */
import createDeck.CreateDeckOutputData;

public interface CreateDeckOutputBoundary {
    void prepareSuccessView(CreateDeckOutputData outputData);

    void prepareFailView(CreateDeckOutputData outputData);
}