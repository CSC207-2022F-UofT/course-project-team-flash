/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 *
 * This file contains the implementation of the DeleteQuizInteractor class,
 * which implements DeleteQuizInputBoundary.
 */

package deleteQuiz;

import entities.Quiz;

public class DeleteQuizInteractor implements DeleteQuizInputBoundary{

    private final DeleteQuizOutputBoundary outputBoundary;

    /**
     * Creates a new DeleteQuizInteractor with the given output boundary.
     *
     * @param outputBoundary the DeleteQuizOutputBoundary associated with the quiz to be deleted
     */
    public DeleteQuizInteractor(DeleteQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * If the quiz name exists, remove it from the quiz tracker.
     * Then, prepares a success view through outputBoundary.
     *
     * If the quiz name does not exist, prepares a fail view through outputBoundary.
     *
     * @param inputData the CreateQuizInputData associated with the created quiz
     */
    @Override
    public void deleteQuiz(DeleteQuizInputData inputData) {
        String quizName = inputData.getQuizName();

        if (!Quiz.getTracker().containsKey(quizName)) {
            DeleteQuizOutputData outputData = new DeleteQuizOutputData(null, "This quiz name does not exist.");
            outputBoundary.prepareFailView(outputData);
        }

        Quiz.removeTracker(quizName);

        DeleteQuizOutputData outputData = new DeleteQuizOutputData(quizName, "Successfully removed quiz.");
        outputBoundary.prepareSuccessView(outputData);
    }
}