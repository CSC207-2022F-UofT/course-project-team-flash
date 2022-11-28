/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains implementation of the CreateCardController class.
 * The task of it is to create a new flashcard. The new flashcard can be
 * of type Q&A or MC.
 */
package createCard;

import entities.Deck;

import java.util.List;

public class CreateCardController {
    final CreateCardInputBoundary inputBoundary;

    /**
     * Creates a new CreateCardController with the given input boundary.
     *
     * @param inputBoundary a CreateCardInputBoundary
     */
    public CreateCardController(CreateCardInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Creates a Q&A (Question and answer) flashcard with the given deck, type, question, and answer.
     *
     * @param deck the deck where the flashcard is to be stored in
     * @param type the type of the flashcard = 1
     *             1: Q&A flashcard
     *             2: MC flashcard
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     */
    public void create(Deck deck, int type, String question, String answer) {
        CreateCardInputData inputData = new CreateCardInputData(deck, type, question, answer);

        inputBoundary.create(inputData);
    }

    /**
     * Creates a MC (Multiple Choice) flashcard with the given deck, type, question, answer, and options.
     *
     * @param deck the deck where the flashcard is to be stored in
     * @param type the type of the flashcard = 2
     *             1: Q&A flashcard
     *             2: MC flashcard
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     * @param options the options for this MC flashcard
     */
    public void create(Deck deck, int type, String question, String answer, List<String> options) {
        CreateCardInputData inputData = new CreateCardInputData(deck, type, question, answer, options);

        inputBoundary.create(inputData);
    }
}
