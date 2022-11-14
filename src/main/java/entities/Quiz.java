package entities;

import java.util.List;

public class Quiz {

    private String quizName;
    private List<Deck> decks;

    /**
     * Constructor for the Quiz object
     * @param quizName a String representing the name of this quiz
     * @param decks a List of decks that is included in this quiz
     */
    public Quiz(String quizName, List<Deck> decks) {
        this.quizName = quizName;
        this.decks = decks;
    }
}
