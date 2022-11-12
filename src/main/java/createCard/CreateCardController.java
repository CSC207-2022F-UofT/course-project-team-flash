/*
 * Author: Andrew Nguyen
 * Date: November 8/22
 * Description: Small description of what this class does
 */
package createCard;

import entities.Deck;

import java.util.List;

public class CreateCardController {
    final CreateCardInputBoundary inputBoundary;

    public CreateCardController(CreateCardInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    // Creates QandAFlashcard
    public void create(Deck deck, int type, String question, String answer) {
        CreateCardInputData inputData = new CreateCardInputData(deck, type, question, answer);

        inputBoundary.create(inputData);
    }

    // Creates MCFlashcard
    public void create(Deck deck, int type, String question, String answer, List<String> options) {
        CreateCardInputData inputData = new CreateCardInputData(deck, type, question, answer, options);

        inputBoundary.create(inputData);
    }
}
