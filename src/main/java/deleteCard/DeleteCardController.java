/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardController
 */
package deleteCard;

/**
 * This file contains the implementation of the DeleteCardController class
 * It contains the instance variables of DeleteCardController and a delete method
 */
public class DeleteCardController{

    final DeleteCardInputBoundary deleteCardInputBoundary;

    /**
     * Creates a new DeleteCardController with a given DeleteCardInputBoundary
     * @param deleteCardInputBoundary a DeleteCardInputBoundary
     */
    public DeleteCardController(DeleteCardInputBoundary deleteCardInputBoundary) {
        this.deleteCardInputBoundary = deleteCardInputBoundary;
    }

    /**
     * Takes in a String cardID and String deckName which will be used in DeleteCardInteractor
     * @param cardID String unique ID of a Flashcard
     * @param deckName String name of the deck containing the flashcard
     */
    public void delete(String cardID, String deckName) {
        DeleteCardInputData deleteCardInputData = new DeleteCardInputData(cardID, deckName);
        deleteCardInputBoundary.delete(deleteCardInputData);
    }

}
