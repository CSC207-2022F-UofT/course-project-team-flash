package delete_deck;

import entities.Deck;
import entities.Flashcard;

public class DeleteDeckInteractor implements DeleteDeckInputBoundary{
    private final DeleteDeckOutputBoundary outputBound;

    /**
     * Creates an interactor instance for the delete deck use case.
     * @param outputBound the output boundary for the deck deletion use case.
     */
    public DeleteDeckInteractor(DeleteDeckOutputBoundary outputBound){
        this.outputBound = outputBound;
    }

    /**
     * Determines if a deck exists, if it does, the deck is deleted.
     * @param inputData data from the controller
     */
    @Override
    public void delete(DeleteDeckInputData inputData) {
        String deckName = inputData.getDeckName();

        if(!Deck.containsDeckName(deckName)){
            outputBound.prepareFailView("Deck not found");
        }

        else {
            Deck currDeck = Deck.getTracker().get(deckName);

            //Remove all cards within the deck from the static flashcard hashmap
            for (String cardId : currDeck.getCardIds()) {
                Flashcard.removeTracker(cardId);
            }

            //Remove the deck from the static flashcard hashmap
            Deck.removeTracker(deckName);

            DeleteDeckOutputData outputData = new DeleteDeckOutputData(deckName);
            outputBound.prepareSuccessView(outputData);
        }
    }
}
