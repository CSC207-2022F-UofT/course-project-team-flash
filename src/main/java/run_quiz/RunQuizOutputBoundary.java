/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 * This file contains an interface named RunQuizOutputBoundary.
 * It has three overloaded interface methods named prepareSuccessView, and
 * one interface method named quizFailView.
 */

package run_quiz;

public interface RunQuizOutputBoundary {

    /**
     * Prepares the success view given a ShowAnswerOutputData, if the quiz exists.
     *
     * @param outputData the ShowAnswerOutputData associated with this problem
     */
    void prepareSuccessView(ShowAnswerOutputData outputData);

    /**
     * Prepares the success view given a ShowProblemOutputData, if the quiz exists.
     *
     * @param outputData the ShowProblemOutputData associated with this problem
     */
    void prepareSuccessView(ShowProblemOutputData outputData);

    /**
     * Prepares the success view given a StartQuizOutputData, if the quiz exists.
     *
     * @param outputData the StartQuizOutputData associated with this quiz
     */
    void prepareSuccessView(StartQuizOutputData outputData);

    /**
     * Prepare the fail view with the error string given.
     *
     * @param error the description of this error
     */
    void quizFailView(String error);
}
