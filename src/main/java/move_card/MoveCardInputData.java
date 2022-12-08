/*
 * Author: Derrick Cho
 * Date: November 13/22
 */
package move_card;

/**
 * This file contains the implementation of the MoveCardInputData class.
 * It includes the instance attributes of MoveCardInputData,
 * and the getter methods for them
 */
public class MoveCardInputData {

    private final String oldDeckID;

    private final String newDeckID;
    private final String cardID;

    /**
     * Creates a new MoveCardInputData with a given Flashcard ID and two deck names
     * @param card String ID of a Flashcard
     * @param oldDeck name of the deck containing the Flashcard
     * @param newDeck name of the deck to contain the Flashcard
     */
    public MoveCardInputData(String card, String oldDeck, String newDeck) {
        this.cardID = card;
        this.oldDeckID = oldDeck;
        this.newDeckID = newDeck;
    }

    /**
     * Returns the oldDeckID of the given MoveCardInputData
     * @return the oldDeckID of the given MoveCardInputData
     */
    public String getOldDeckID() {
        return this.oldDeckID;
    }

    /**
     * Returns the newDeckID of the given MoveCardInputData
     * @return the newDeckID of the given MoveCardInputData
     */
    public String getNewDeckID() { return this.newDeckID; }

    /**
     * Returns the cardID of the given MoveCardInputData
     * @return the cardID of the given MoveCardInputData
     */
    public String getCardID() {
        return this.cardID;
    }
}
