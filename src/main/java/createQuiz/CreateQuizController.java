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

    public CreateQuizOutputData createQuiz(String quizName, List<String> quizDecksNames) {
        CreateQuizInputData requestModel = new CreateQuizInputData(quizName, quizDecksNames);
        return inputBoundary.createQuiz(requestModel);
    }
}
