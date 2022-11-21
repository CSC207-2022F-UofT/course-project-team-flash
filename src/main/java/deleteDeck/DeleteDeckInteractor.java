package deleteDeck;

import entities.Deck;
import entities.Flashcard;

import java.util.List;
import java.util.Map;

public class DeleteDeckInteractor implements DeleteDeckInputBoundary{

    private final DeleteDeckOutputBoundary outputBound;

    DeleteDeckInteractor(DeleteDeckOutputBoundary outputBound){
        this.outputBound = outputBound;
    }

    @Override
    public void delete(DeleteDeckInputData inputData) {

        String deckName = inputData.getDeckName();

        if(!Deck.containsDeckName(deckName)){
            outputBound.prepareFailView("Deck not found");
        }

        Deck currDeck = Deck.getTracker().get(deckName);


        //Remove all cards within the deck from the static flashcard hashmap
        for(String cardId : currDeck.getCardIds()){
            Flashcard.removeTracker(cardId);
        }

        //Remove the deck from the static flashcard hashmap
        Deck.removeTracker(deckName);


        DeleteDeckOutputData outputData = new DeleteDeckOutputData(deckName);

        outputBound.prepareSuccessView(outputData);

    }
}
