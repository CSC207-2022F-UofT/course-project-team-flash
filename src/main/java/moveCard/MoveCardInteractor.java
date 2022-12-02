package moveCard;

import entities.Flashcard;

import entities.Deck;

/**
 * This file contains the implementation of the MoveCardInteractor class
 * It includes the instance attributes of MoveCardInteractor
 * and a move method
 */
public class MoveCardInteractor implements MoveCardInputBoundary{

    private MoveCardOutputBoundary moveCardOutputBoundary;

    /**
     * Creates a new MoveCardInteractor with a given MoveCardOutputBoundary
     * @param moveCardOutputBoundary a MoveCardOutputBoundary
     */
    public MoveCardInteractor(MoveCardOutputBoundary moveCardOutputBoundary) {
        this.moveCardOutputBoundary = moveCardOutputBoundary;
    }

    /**
     * Takes in a MoveCardInputData and assigns a success or fail view to moveCardOutputData
     * @param moveCardInputData a MoveCardInputData
     */
    @Override
    public void move(MoveCardInputData moveCardInputData) {

        if (!(Deck.getTracker().containsKey(moveCardInputData.getOldDeckID())) ||
                !(Deck.getTracker().containsKey(moveCardInputData.getNewDeckID()))) {
            MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Deck not found");
            moveCardOutputBoundary.prepareFailView(moveCardOutputData);
        }

        Deck oldDeck = Deck.getTracker().get(moveCardInputData.getOldDeckID());
        Deck newDeck = Deck.getTracker().get(moveCardInputData.getNewDeckID());

        if (!(Flashcard.getTracker().containsKey(moveCardInputData.getCardID())) ||
        (!(oldDeck.getCards().contains(Flashcard.getTracker().get(moveCardInputData.getCardID()))))){
            MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Card not found");
            moveCardOutputBoundary.prepareFailView(moveCardOutputData);
        } else {

            Flashcard card = Flashcard.getTracker().get(moveCardInputData.getCardID());

            oldDeck.removeCard(card);
            newDeck.addCard(card);

            MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Flashcard moved.");
            moveCardOutputBoundary.prepareSuccessView(moveCardOutputData);
        }
    }
}
