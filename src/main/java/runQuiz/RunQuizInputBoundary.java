/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains an interface named RunQuizInputBoundary with interface methods startQuiz,
 * showProblem, and showAnswer.
 */

package runQuiz;

public interface RunQuizInputBoundary {

    void startQuiz(StartQuizInputData inputData);

    void showProblem(ShowQuizCardInputData inputData);

    void showAnswer(ShowQuizCardInputData inputData);

}
