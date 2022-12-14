/*
 * Author: Derrick Cho
 * Date: November 13/22
 */

package move_card;

import entities.Flashcard;
import entities.Deck;

/**
 * This file contains the implementation of the MoveCardInteractor class
 * It includes the instance attributes of MoveCardInteractor
 * and a move method
 */
public class MoveCardInteractor implements MoveCardInputBoundary{

    private final MoveCardOutputBoundary moveCardOutputBoundary;

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

        String newDeckName = moveCardInputData.getNewDeckID();
        String oldDeckName = moveCardInputData.getOldDeckID();
        String cardID = moveCardInputData.getCardID();

        if (!(Deck.getTracker().containsKey(newDeckName)) || !(Deck.getTracker().containsKey(oldDeckName))) {
            MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Deck not found", null);
            moveCardOutputBoundary.prepareFailView(moveCardOutputData);
        } else {

            Deck oldDeck = Deck.getTracker().get(oldDeckName);
            Deck newDeck = Deck.getTracker().get(newDeckName);
            Flashcard card = Flashcard.getTracker().get(cardID);

            if (oldDeck.getCards().contains(card)) {

                oldDeck.removeCard(card);
                newDeck.addCard(card);
                String id = card.getUniqueID();

                MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Flashcard moved.", id);
                moveCardOutputBoundary.prepareSuccessView(moveCardOutputData);

            } else {
                MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Card not found", null);
                moveCardOutputBoundary.prepareFailView(moveCardOutputData);
            }
        }
    }
}
