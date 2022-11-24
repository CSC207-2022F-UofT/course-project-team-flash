/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains implementation of the RunQuizController class.
 * The task of it is to run a quiz.
 */

package runQuiz;

public class RunQuizController {

    final RunQuizInputBoundary runQuizInputBound;

    /**
     * Creates a new RunQuizController with the given input boundary.
     *
     * @param runQuizInputBound a RunQuizInputBoundary
     */
    RunQuizController(RunQuizInputBoundary runQuizInputBound){
        this.runQuizInputBound = runQuizInputBound;
    }

    /**
     * Returns a ShowAnswerOutputData given a quiz name and a list of deck names that will be
     * in the created quiz object.
     *
     * @param flashcardIdList a list of flashcard IDs
     * @param currCardIndex the index of the current card in flashcardIdList
     * @param  userAnswer the user's answer
     * @return a ShowAnswerOutputData for this flashcard question
     */
    ShowAnswerOutputData showAnswer(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex, userAnswer);

        return runQuizInputBound.showAnswer(inputData);
    }

    /**
     * Returns a ShowProblemOutputData given a list of flashcard IDs and the index of the
     * current card in this list.
     *
     * @param flashcardIdList a list of flashcard IDs
     * @param currCardIndex the index of the current card in flashcardIdList
     * @return a ShowProblemOutputData for this flashcard problem
     */
    ShowProblemOutputData showProblem(String[] flashcardIdList, int currCardIndex){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex);

        return runQuizInputBound.showProblem(inputData);
    }

    /**
     * Returns a StartQuizOutputData given a quiz ID (name) and whether the problems in this quiz
     * appear in a randomized order.
     *
     * @param quizId the ID (name) of this quiz
     * @param isRandomized whether the problems in this quiz appear in a randomized order
     * @return a StartQuizOutputData for this quiz to start
     */
    StartQuizOutputData startQuiz(String quizId, boolean isRandomized){
        StartQuizInputData inputData = new StartQuizInputData(quizId, isRandomized);

        return runQuizInputBound.startQuiz(inputData);
    }

}
