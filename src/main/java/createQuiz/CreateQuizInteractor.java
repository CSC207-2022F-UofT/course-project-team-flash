package createQuiz;

import entities.Deck;
import entities.Quiz;

import java.util.List;

public class CreateQuizInteractor implements CreateQuizInputBoundary{

    private final CreateQuizOutputBoundary outputBoundary;

    public CreateQuizInteractor(CreateQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public CreateQuizOutputData createQuiz(CreateQuizInputData inputData) {
        String quizName = inputData.getQuizName();
        List<Deck> quizDecks = inputData.getQuizDecks();

        if (Quiz.getTracker().containsKey(quizName)) {
            String message = "This quiz name exists already. Failed to create new quiz";
            return new CreateQuizOutputData(null, message);
        } else {
            Quiz quiz = new Quiz(quizName, quizDecks);
            String message = "Successfully created new quiz";
            Quiz.addTracker(quizName, quiz);
            return new CreateQuizOutputData(quiz, message);
        }
    }
}
