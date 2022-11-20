package createQuiz;

import entities.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateQuizInputData {

    private final String quizName;
//    private final List<String> quizDecksNames;
    private final List<Deck> quizDecks;

    public CreateQuizInputData(String quizName, List<Deck> quizDecks) {
        this.quizName = quizName;
        this.quizDecks = quizDecks;
//        this.quizDecksNames = quizDecksNames;
//        this.quizDecks = deckNamesToDecks(quizDecksNames);
    }

    public String getQuizName() {
        return this.quizName;
    }

//    public List<String> getQuizDecksNames() {
//        return this.quizDecksNames;
//    }

    public List<Deck> getQuizDecks() {
        return this.quizDecks;
    }

//    private List<Deck> deckNamesToDecks(List<String> quizDecksNames) {
//
//        List<Deck> quizDecks = new ArrayList<>();
//        Map<String, Deck> deckTracker = Deck.getTracker();
//
//        for (String deckName: quizDecksNames) {
//            quizDecks.add(deckTracker.get(deckName));
//        }
//
//        return quizDecks;
//    }

}
