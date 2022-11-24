package editCard;
/*
 * Author: Albert Yan
 * Date: October 31/22
 * The edit card controller for edit card systems, receives the arguments required to perform an edit card action
 */

import entities.Flashcard;

import java.util.List;

public class EditCardController {

    final EditCardInputBoundary inputBoundary;

    public EditCardController(EditCardInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    // Edit QnA card
    public void edit(String cardID, String question, String answer) {
        EditCardInputData inputData = new EditCardInputData(cardID, question, answer);
        inputBoundary.edit(inputData);
    }

    // Edit MC card
    public void edit(String cardID, String question, String answer, List<String> options) {
        EditCardInputData inputData = new EditCardInputData(cardID, question, answer, options);
        inputBoundary.edit(inputData);
    }
}
