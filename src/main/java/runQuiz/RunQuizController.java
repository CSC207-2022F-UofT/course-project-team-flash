/**
 * Author: Jamie Chew
 * Documentation Author: Jamie Chew
 * Date: December 7th, 2022
 *
 * This file contains the RunQuizController class. This includes its constructor
 * and 3 methods that call their respective use case interactors (startQuiz,
 * showProblem, and showAnswer).
 */

package runQuiz;

public class RunQuizController {

    RunQuizInputBoundary runQuizInputBound;

    /**
     * Create a new RunQuizController with the given input boundary.
     * @param runQuizInputBound the input boundary to the interactor.
     */
    public RunQuizController(RunQuizInputBoundary runQuizInputBound){
        this.runQuizInputBound = runQuizInputBound;
    }


    /**
     * Create an input data object to pass to the interactor with the information
     * inputted by the user.
     *
     * @param flashcardIdList a list of flashcard ids.
     * @param currCardIndex the current index within the flashcard ids.
     * @param userAnswer the user's answer to a flashcard.
     */
    public void showAnswer(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex, userAnswer);

        runQuizInputBound.showAnswer(inputData);
    }

    /**
     * Create an input data object to pass to the interactor with the information
     * inputted by the user.
     *
     * @param flashcardIdList a list of flashcard ids.
     * @param currCardIndex the current index within the flashcard ids.
     */
    public void showProblem(String[] flashcardIdList, int currCardIndex){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex);

        runQuizInputBound.showProblem(inputData);
    }

    /**
     * Create an input data object to pass to the interactor with the information
     * inputted by the user.
     *
     * @param quizId the ID for the quiz to be started
     * @param isRandomized whether the quiz's flashcards should be randomized or not
     */
    public void startQuiz(String quizId, boolean isRandomized){
        StartQuizInputData inputData = new StartQuizInputData(quizId, isRandomized);

        runQuizInputBound.startQuiz(inputData);
    }

}
