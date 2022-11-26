package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * The output data class for edit card systems, packages data related to output together to be sent to viewmodel
 */

import entities.Flashcard;

/**
 * This file contains implementation of the EditCardOutputData class.
 * It includes the instance attributes of EditCardOutputData,
 * and the getter methods for them
 */
public class EditCardOutputData {

    private Flashcard card;
    private String message;

    /**
     * Creates a new EditCardOutputData with a given Flashcard and String message
     * @param card Flashcard object
     * @param message String indicating whether this flashcard was edited successfully
     */
    public EditCardOutputData(Flashcard card, String message) {
        this.card = card;
        this.message = message;
    }

    /**
     * Return the card of the given EditCardOutputBoundary
     * @return the card of the given EditCardOutputBoundary
     */
    public Flashcard getCard() {
        return card;
    }

    /**
     * Return the message of the given EditCardInputBoundary
     * @return the message of the given EditCardInputBoundary
     */
    public String getMessage() {
        return message;
    }
}
