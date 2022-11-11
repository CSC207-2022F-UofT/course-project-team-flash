package createQuiz;

import entities.Deck;
import entities.Quiz;

import java.util.List;

public class CreateQuizInteracter implements CreateQuizInputBoundary{

    private final CreateQuizOutputBoundary outputBoundary;

    public CreateQuizInteracter(CreateQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public CreateQuizOutputData createQuiz(CreateQuizInputData inputData) {
        String quizName = inputData.getQuizName();
        List<Deck> quizDecks = inputData.getQuizDecks();

        Quiz quiz = new Quiz(quizName, quizDecks);
        quiz.storeQuiz();
        String message = "Successful";

        CreateQuizOutputData outputData = new CreateQuizOutputData(quiz, message);
        return outputData;
    }
}
