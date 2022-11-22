/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains an interface named RunQuizOutputBoundary.
 * It has three overloaded interface methods named prepareSuccessView, and
 * one interface method named quizFailView.
 */

package runQuiz;

public interface RunQuizOutputBoundary {

    void prepareSuccessView(ShowAnswerOutputData outputData);

    void prepareSuccessView(ShowProblemOutputData outputData);

    void prepareSuccessView(StartQuizOutputData outputData);

    void quizFailView(String error);
}
