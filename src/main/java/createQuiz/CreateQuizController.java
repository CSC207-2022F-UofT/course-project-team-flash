package createQuiz;

import entities.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateQuizController {

    private final CreateQuizInputBoundary inputBoundary;

    public CreateQuizController(CreateQuizInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public CreateQuizOutputData createQuiz(String quizName, List<Deck> quizDecks) {
        CreateQuizInputData requestModel = new CreateQuizInputData(quizName, quizDecks);
        return inputBoundary.createQuiz(requestModel);
    }
}
