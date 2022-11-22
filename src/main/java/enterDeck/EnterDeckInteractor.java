package enterDeck;

import entities.Deck;

import java.util.List;

public class EnterDeckInteractor implements EnterDeckInputBoundary {
    final EnterDeckOutputBoundary outputBoundary;

    public EnterDeckInteractor(EnterDeckOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void enter(EnterDeckInputData inputData) {
        Deck deck = Deck.getTracker().get(inputData.getDeckName());
        List<String> cardIDs = deck.getCardIds();

        EnterDeckOutputData outputData = new EnterDeckOutputData(cardIDs);
        outputBoundary.prepareSuccessView(outputData);
    }
}
