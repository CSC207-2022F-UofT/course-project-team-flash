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
        Flashcard card = Flashcard.getTracker().get(moveCardInputData.getCardID());
        Deck oldDeck = Deck.getTracker().get(moveCardInputData.getOldDeckID());
        Deck newDeck = Deck.getTracker().get(moveCardInputData.getNewDeckID());

        oldDeck.removeCard(card);
        newDeck.addCard(card);

        MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Flashcard moved.");
        moveCardOutputBoundary.prepareSuccessView(moveCardOutputData);
    }
}
