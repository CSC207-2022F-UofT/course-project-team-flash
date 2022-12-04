/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */

package createCard;

import entities.FlashcardType;

import java.util.List;

/**
 * This file contains implementation of the CreateCardInputData class.
 * It includes two overloaded constructor methods for CreateCardInputData, one for MC flashcards, the other for Q&A
 * flashcards.
 * It also includes the instance attributes of CreateCardInputData and the getter methods for them.
 */
public class CreateCardInputData {
    private final String deckName;
    private final String question;
    private final String answer;
    private final FlashcardType type;
    private final List<String> options;

    /**
     * Creates a new CreateCardInputData for MC flashcard with the given deck, type, question, answer, and options.
     *
     * @param deckName the name deck where the flashcard is to be stored in
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     * @param options the options for this MC flashcard
     */
    public CreateCardInputData(String deckName, String question, String answer, List<String> options) {
        this.deckName = deckName;
        this.type = FlashcardType.MCFlashcard;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    /**
     * Creates a new CreateCardInputData for Q&A flashcard with the given deck, type, question, and answer.
     * The options of this CreateCardInputData will be set to null.
     *
     * @param deckName the name of the deck where the flashcard is to be stored in
     * @param question the question part of this flashcard
     * @param answer the answer part of this flashcard
     */
    public CreateCardInputData(String deckName, String question, String answer) {
        this.deckName = deckName;
        this.type = FlashcardType.QandAFlashcard;
        this.question = question;
        this.answer = answer;
        this.options = null;
    }

    /**
     * Returns the deckName of this CreateCardInputData.
     *
     * @return the deckName of this CreateCardInputData
     */
    public String getDeckName() {
        return deckName;
    }

    /**
     * Returns the type of this CreateCardInputData.
     *
     * @return the type of this CreateCardInputData
     */
    public FlashcardType getType() {
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
