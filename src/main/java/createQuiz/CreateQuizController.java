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
     * Return a CreateQuizOutputData given a quiz name and a list of deck names that will be
     * in the created quiz object.
     *
     * @param quizName the name of the quiz
     * @param quizDecksNames the list of deck names that will be included in the quiz
     * @return a CreateQuizOutputData associated with this created quiz
     */
    public CreateQuizOutputData createQuiz(String quizName, List<String> quizDecksNames) {
        CreateQuizInputData requestModel = new CreateQuizInputData(quizName, quizDecksNames);
        return inputBoundary.createQuiz(requestModel);
    }
}
