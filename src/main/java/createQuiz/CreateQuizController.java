/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */

package createQuiz;
import java.util.List;

/**
 * This file contains implementation of the CreateQuizController class.
 * The task of it is to create a new quiz.
 */
public class CreateQuizController {

    private final CreateQuizInputBoundary inputBoundary;

    /**
     * Creates a new CreateQuizController with the given input boundary.
     *
     * @param inputBoundary a CreateQuizInputBoundary
     */
    public CreateQuizController(CreateQuizInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Calls inputBoundary.createQuizOutputData given a quiz name and a list of deck names that will be
     * in the created quiz object.
     *
     * @param quizName the name of the quiz
     * @param quizDecksNames the list of deck names that will be included in the quiz
     */
    public void createQuiz(String quizName, List<String> quizDecksNames) {
        CreateQuizInputData inputData = new CreateQuizInputData(quizName, quizDecksNames);
        inputBoundary.createQuiz(inputData);
    }
}