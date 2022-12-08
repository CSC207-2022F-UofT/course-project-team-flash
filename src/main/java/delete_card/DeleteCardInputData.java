/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardInputData
 */
package delete_card;

/**
 * This file contains the implementation of the DeleteCardInputData class
 * It contains the instance variables of DeleteCardInputData
 * and contains the getter methods for them
 */
public class DeleteCardInputData {

    private final String cardID;
    private final String deckName;

    /**
     * Creates a new DeleteCardInputData with the given String cardID and deckName
     * @param cardID String unique ID of a Flashcard
     * @param deckName String name of the deck containing the flashcard
     */
    public DeleteCardInputData(String cardID, String deckName){
        this.cardID = cardID;
        this.deckName = deckName;
    }

    /**
     * Returns the cardID of the given DeleteCardInputData
     * @return the cardID of the given DeleteCardInputData
     */
    public String getCardID() {
        return this.cardID;
    }

    /**
     * Returns the deckName of the given DeleteCardInputData
     * @return the deckName of the given DeleteCardInputData
     */
    public String getDeckName() {
        return this.deckName;
    }
}
