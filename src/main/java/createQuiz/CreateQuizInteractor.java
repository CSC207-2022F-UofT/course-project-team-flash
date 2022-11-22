package createQuiz;

import entities.Deck;
import entities.Quiz;

import java.util.List;
/**
 * This file contains the implementation of the CreateQuizInteractor class,
 * which implements CreateQuizInputBoundary.
 */

public class CreateQuizInteractor implements CreateQuizInputBoundary{

    private final CreateQuizOutputBoundary outputBoundary;

    /**
     * Creates a new CreateQuizInteractor with the given output boundary.
     *
     * @param outputBoundary the CreateQuizOutputBoundary associated with the created quiz
     */
    public CreateQuizInteractor(CreateQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Return a CreateQuizOutputData given the input data.
     *
     * @param inputData the CreateQuizInputData associated with the created quiz
     * @return a CreateQuizOutputData associated with this created quiz
     */
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
