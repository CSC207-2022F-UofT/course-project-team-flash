/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateQuizInteractor class,
 * which implements CreateQuizInputBoundary.
 */

package createQuiz;

import entities.Deck;
import entities.Quiz;

import java.util.List;

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
     * If the quiz name does not exist already, creates the quiz and stores it to the quiz tracker.
     * Then, prepares a success view through outputBoundary.
     *
     * If the quiz name already exists, prepares a fail view through outputBoundary.
     *
     * @param inputData the CreateQuizInputData associated with the created quiz
     */
    @Override
    public void createQuiz(CreateQuizInputData inputData) {
        String quizName = inputData.getQuizName();
        List<Deck> quizDecks = inputData.getQuizDecks();

        if (Quiz.getTracker().containsKey(quizName)) {
            CreateQuizOutputData outputData = new CreateQuizOutputData(null,
                    "This quiz name exists already. Failed to create new quiz.");
            outputBoundary.prepareFailView(outputData);
        }

        Quiz quiz = new Quiz(quizName, quizDecks);
        Quiz.addTracker(quizName, quiz);

        CreateQuizOutputData outputData = new CreateQuizOutputData(quizName, "Successfully created new quiz");
        outputBoundary.prepareSuccessView(outputData);
    }
}