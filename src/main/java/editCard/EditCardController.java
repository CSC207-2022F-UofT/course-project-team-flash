/*
 * Author: Albert Yan
 * Date: October 31/22
 * The edit card controller for edit card systems, receives the arguments required to perform an edit card action
 */

package editCard;

import java.util.List;

/**
 * This file contains an implementation of the EditCardController class
 */
public class EditCardController {

    private final EditCardInputBoundary inputBoundary;

    /**
     * Creates a new EditCardController with the given input boundary
     * @param inputBoundary an EditCardInputBoundary
     */
    public EditCardController(EditCardInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    // Edit QnA card
    /**
     * Takes in a String Flashcard ID along with the String question and answer that will be
     * used in EditCardInteractor.
     * @param cardID String ID for the Flashcard
     * @param question Current Flashcard question
     * @param answer Current Flashcard answer
     */
    public void edit(String cardID, String question, String answer) {
        EditCardInputData inputData = new EditCardInputData(cardID, question, answer);
        inputBoundary.edit(inputData);
    }

    // Edit MC card
    /**
     * Takes in a String Flashcard ID, String question and answer, and a List of all MC answers that will be
     * used in EditCardInteractor.
     * @param cardID String ID for the Flashcard
     * @param question Current Flashcard question
     * @param answer Current Flashcard answer
     * @param options List of all listed answers
     */
    public void edit(String cardID, String question, String answer, List<String> options) {
        EditCardInputData inputData = new EditCardInputData(cardID, question, answer, options);
        inputBoundary.edit(inputData);
    }
}
