package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * This class is a container for the input data related to edit card systems,
 * it is created by the controller and sent to the interactor
 */

import entities.Flashcard;

import java.util.List;
/**
 * This file contains implementation of the EditCardInputData class.
 * It includes the instance attributes of EditCardInputData,
 * and the getter methods for them
 */

public class EditCardInputData {

    private final String cardID;
    private final String question;
    private final String answer;
    private final List<String> options;

    /**
     * Creates a new EditCardInputData with the given String FlashCard ID and Strings question and answer
     * @param cardID String ID of Flashcard
     * @param question Current Flashcard question
     * @param answer Current Flashcard answer
     */
    public EditCardInputData(String cardID, String question, String answer) {
        this.cardID = cardID;
        this.question = question;
        this.answer = answer;
        this.options = null;
    }

    /**
     * Creates a new EditCardInputData with the given String Flashcard ID, Strings question and answer,
     * and List of all answers
     * @param cardID String ID of Flashcard
     * @param question Current Flashcard question
     * @param answer Current Flashcard answer
     * @param options List of all listed answers
     */
    public EditCardInputData(String cardID, String question, String answer, List<String> options) {
        this.cardID = cardID;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    /**
     * Return the cardID of the given EditCardInputData
     * @return the cardID of the given EditCardInputData
     */
    public String getCardID() {
        return cardID;
    }

    /**
     * Return the question of the given EditCardInputData
     * @return the question of the given EditCardInputData
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Return the answer of the given EditCardInputData
     * @return the answer of the given EditCardInputData
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Return the options of the given EditCardInputData
     * @return the options of the given EditCardInputData
     */
    public List<String> getOptions() { return options; }
}
