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

        String message;
        CreateQuizOutputData outputData;

        if (Quiz.getTracker().containsKey(quizName)) {
            message = "This quiz name exists already. Failed to create new quiz";
            outputData = new CreateQuizOutputData(null, message);
        } else {
            Quiz quiz = new Quiz(quizName, quizDecks);
            message = "Successfully created new quiz";
            Quiz.addTracker(quizName, quiz);
            outputData = new CreateQuizOutputData(quiz, message);
        }

        return outputData;
    }
}
