package createQuiz;

import entities.Deck;

import java.util.List;

public class CreateQuizInputData {

    private final String quizName;
    private final List<Deck> quizDecks;

    public CreateQuizInputData(String quizName, List<Deck> quizDecks) {
        this.quizName = quizName;
        this.quizDecks = quizDecks;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public List<Deck> getQuizDecks() {
        return this.quizDecks;
    }

}
