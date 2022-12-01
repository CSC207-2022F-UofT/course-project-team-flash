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

    private String id;

    private String question;

    private String answer;
    private String message;

    /**
     * Creates a new EditCardOutputData with a given Flashcard and String message
     * @param id String id of the edited flashcard
     * @param question String new question of the edited flashcard
     * @param answer String new answer the edited flashcard
     * @param message String indicating whether this flashcard was edited successfully
     */
    public EditCardOutputData(String id, String question, String answer, String message) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.message = message;
    }

    /**
     * Return the id of card the given EditCardOutputBoundary
     * @return the id of the card of the given EditCardOutputBoundary
     */
    public String getID() {
        return id;
    }

    /**
     * Return the id of card the given EditCardOutputBoundary
     * @return the id of the card of the given EditCardOutputBoundary
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Return the id of card the given EditCardOutputBoundary
     * @return the id of the card of the given EditCardOutputBoundary
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Return the message of the given EditCardInputBoundary
     * @return the message of the given EditCardInputBoundary
     */
    public String getMessage() {
        return message;
    }
}
