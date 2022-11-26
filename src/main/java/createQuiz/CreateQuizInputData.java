/**
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains implementation of the CreateQuizInputData class.
 * It includes the instance attributes of CreateQuizInputData,
 * the getter methods for them, and a private method deckNamesToDecks.
 */

package createQuiz;

import entities.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateQuizInputData {

    private final String quizName;
    private final List<String> quizDecksNames;
    private final List<Deck> quizDecks;

    /**
     * Creates a new CreateQuizInputData with the given quiz name and the quiz decks' names.
     *
     * @param quizName the name of the quiz
     * @param quizDecksNames the list of deck names that will be included in the quiz
     */
    public CreateQuizInputData(String quizName, List<String> quizDecksNames) {
        this.quizName = quizName;
        this.quizDecksNames = quizDecksNames;
        this.quizDecks = deckNamesToDecks(quizDecksNames);
    }

    /**
     * Returns the quiz name of this CreateQuizInputData.
     *
     * @return the quiz name of this CreateQuizInputData
     */
    public String getQuizName() {
        return this.quizName;
    }

    /**
     * Returns the decks' names of this CreateQuizInputData.
     *
     * @return the decks' names of this CreateQuizInputData
     */
    public List<String> getQuizDecksNames() {
        return this.quizDecksNames;
    }

    /**
     * Returns the quiz decks of this CreateQuizInputData.
     *
     * @return the quiz decks of this CreateQuizInputData
     */
    public List<Deck> getQuizDecks() {
        return this.quizDecks;
    }

    /**
     * Return a list of decks referred to by the given list of deck names.
     * This method is only used in the constructor method of this CreateQuizInputData class.
     *
     * @param quizDecksNames the list of deck names that will be included in the quiz
     * @return a list of decks referred to by quizDecksNames
     */
    private List<Deck> deckNamesToDecks(List<String> quizDecksNames) {

        List<Deck> quizDecks = new ArrayList<>();
        Map<String, Deck> deckTracker = Deck.getTracker();

        for (String deckName: quizDecksNames) {
            quizDecks.add(deckTracker.get(deckName));
        }

        return quizDecks;
    }

}
