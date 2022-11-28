/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains implementation of the CreateCardInputData class.
 * It includes two overloaded constructor methods for CreateCardInputData, one for MC flashcards, the other for Q&A
 * flashcards.
 * It also includes the instance attributes of CreateCardInputData and the getter methods for them.
 */

package createCard;

import entities.Deck;

import java.util.List;

public class CreateCardInputData {
    private final Deck deck;
    private final String question;
    private final String answer;
    private final int type;
    private final List<String> options;

    /**
     * Creates a new CreateCardInputData for MC flashcard with the given deck, type, question, answer, and options.
     *
     * @param deck the deck where the flashcard is to be stored in
     * @param type the type of the flashcard = 2
     *             1: Q&A flashcard
     *             2: MC flashcard
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     * @param options the options for this MC flashcard
     */
    public CreateCardInputData(Deck deck, int type, String question, String answer, List<String> options) {
        this.deck = deck;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    /**
     * Creates a new CreateCardInputData for Q&A flashcard with the given deck, type, question, and answer.
     * The options of this CreateCardInputData will be set to null.
     *
     * @param deck the deck where the flashcard is to be stored in
     * @param type the type of the flashcard = 2
     *             1: Q&A flashcard
     *             2: MC flashcard
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     */
    public CreateCardInputData(Deck deck, int type, String question, String answer) {
        this.deck = deck;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.options = null;
    }

    /**
     * Returns the deck of this CreateCardInputData.
     *
     * @return the deck of this CreateCardInputData
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Returns the type of this CreateCardInputData.
     *
     * @return the type of this CreateCardInputData
     */
    public int getType() {
        return type;
    }

    /**
     * Returns the answer of this CreateCardInputData.
     *
     * @return the answer of this CreateCardInputData
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns the question of this CreateCardInputData.
     *
     * @return the question of this CreateCardInputData
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the options of this CreateCardInputData.
     *
     * @return the options of this CreateCardInputData
     */
    public List<String> getOptions() {
        return options;
    }

}
