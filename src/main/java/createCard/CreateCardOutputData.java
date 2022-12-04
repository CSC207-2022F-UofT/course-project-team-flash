/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateCardOutputData class.
 * It includes the instance attributes of the CreateCardOutputData class and
 * their getter methods.
 * It also has two overloaded constructor methods, one for a failed creation of flashcard, the other for a successful
 * one.
 */

package createCard;

public class CreateCardOutputData {
    private final String message;
    private final String type;
    private final String question;
    private final String answer;
    private final String uniqueID;

    /**
     * Creates a new CreateCardOutputData given an error message, when the flashcard cannot be successfully created.
     *
     * @param errorMessage the error message for this failure of creating a flashcard
     */
    public CreateCardOutputData(String errorMessage) {
        this.message = errorMessage;
        this.type = null;
        this.question = null;
        this.answer = null;
        this.uniqueID = null;
    }

    /**
     * Creates a new CreateCardOutputData given a message, type, question, and answer.
     *
     * @param message the message for this success of creating a flashcard
     * @param type the type of the flashcard = 2
     *             1: Q&A flashcard
     *             2: MC flashcard
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     * @param uniqueID the unique ID of the card
     */
    public CreateCardOutputData(String message, int type, String question, String answer, String uniqueID) {
        this.message = message;

        String strType = "";
        if (type == 1) {
            strType = "Question and Answer";
        } else if (type == 2) {
            strType = "Multiple Choice";
        } else if (type == 3) {
            strType = "Select All";
        }

        this.type = strType;
        this.question = question;
        this.answer = answer;
        this.uniqueID = uniqueID;
    }

    /**
     * Returns the message of this CreateCardOutputData.
     *
     * @return the message of this CreateCardOutputData
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the type of this CreateCardOutputData.
     *
     * @return the type of this CreateCardOutputData
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the question of this CreateCardOutputData.
     *
     * @return the question of this CreateCardOutputData
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer of this CreateCardOutputData.
     *
     * @return the answer of this CreateCardOutputData
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns a string representing the card's unique ID
     *
     * @return the uniqueID of this createCardOutputData
     */
    public String getUniqueID() {
        return uniqueID;
    }
}
