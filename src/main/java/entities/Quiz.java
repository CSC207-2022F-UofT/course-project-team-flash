package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private String quizName;
    private List<Deck> decks;

    private static final Map<String, Quiz> quizTracker = new HashMap<>();

    /**
     * Constructor for the Quiz object
     * @param quizName a String representing the name of this quiz
     * @param decks a List of decks that is included in this quiz
     */
    public Quiz(String quizName, List<Deck> decks) {
        this.quizName = quizName;
        this.decks = decks;
    }

    public List<Deck> getDecks(){
        return this.decks;
    }

    public static Quiz getQuiz(String quizId){
        return quizTracker.get(quizId);

    }


}
