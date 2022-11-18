package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private final String quizName;
    private final List<Deck> decks;
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

    public static Map<String, Quiz> getTracker() {
        return quizTracker;
    }
    public static void addTracker(String quizName, Quiz quiz) {
        quizTracker.put(quizName, quiz);
    }
    public static void removeTracker(String quizName) {
        quizTracker.remove(quizName);
    }
}
