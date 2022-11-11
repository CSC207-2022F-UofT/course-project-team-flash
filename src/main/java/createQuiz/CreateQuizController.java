package createQuiz;

import entities.Deck;

import java.util.List;

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
