/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 */

package delete_quiz;

/**
 * This file contains implementation of the DeleteQuizController class.
 * The task of it is to delete an existing quiz.
 */
public class DeleteQuizController {

    private final DeleteQuizInputBoundary inputBoundary;

    /**
     * Creates a new DeleteQuizController with the given input boundary.
     *
     * @param inputBoundary a DeleteQuizInputBoundary
     */
    public DeleteQuizController(DeleteQuizInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Calls inputBoundary.deleteQuizOutputData given a quiz name.
     *
     * @param quizName the name of the quiz
     */
    public void deleteQuiz(String quizName) {
        DeleteQuizInputData inputData = new DeleteQuizInputData(quizName);
        inputBoundary.deleteQuiz(inputData);
    }
}