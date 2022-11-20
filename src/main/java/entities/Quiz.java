package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private String quizName;
    private List<Deck> decks;
    private static final Map<String, Quiz> quizTracker = new HashMap<>();

    public Quiz(String quizName, List<Deck> decks) {
        this.quizName = quizName;
        this.decks = decks;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public List<Deck> getDecks() {
        return this.decks;
    }

    public static Quiz getQuiz(String quizName) {
        return quizTracker.get(quizName);
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


