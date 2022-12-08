/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 * This file contains an interface named RunQuizInputBoundary with interface methods startQuiz,
 * showProblem, and showAnswer.
 */

package run_quiz;

public interface RunQuizInputBoundary {
    /**
     * Creates a StartQuizOutputData and passes it to the presenter.
     * If the quiz does not exist, gives fail view output data;
     * otherwise, returns success view output data.
     *
     * @param inputData the StartQuizInputData associated with the quiz to be run
     */

    void startQuiz(StartQuizInputData inputData);
    /**
     * Creates a ShowProblemOutputData and passes it to the presenter.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     */
    void showProblem(ShowQuizCardInputData inputData);

    /**
     * Creates a ShowAnswerOutputData and passes it to the presenter.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     */
    void showAnswer(ShowQuizCardInputData inputData);

}
