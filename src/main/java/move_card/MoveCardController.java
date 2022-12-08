/*
 * Author: Derrick Cho
 * Date: November 13/22
 */
package move_card;

/**
 * This file contains the implementation of the MoveCardController class
 */
public class MoveCardController {

    final MoveCardInputBoundary moveCardInputBoundary;

    /**
     * Creates a new MoveCardController with a given MoveCardInputBoundary
     * @param moveCardInputBoundary a MoveCardInputBoundary
     */
    public MoveCardController(MoveCardInputBoundary moveCardInputBoundary) {
        this.moveCardInputBoundary = moveCardInputBoundary;
    }

    /**
     * Takes in two deck names as well as a Flashcard ID that will be used
     * in MoveCardInteractor
     * @param oldDeck name of the current deck containing the Flashcard
     * @param newDeck name of the new deck to contain the Flashcard
     * @param card String ID of the Flashcard
     */
    public void move(String oldDeck, String newDeck, String card) {
        MoveCardInputData moveCardInputData = new MoveCardInputData(card, oldDeck, newDeck);

        moveCardInputBoundary.move(moveCardInputData);
    }
}
