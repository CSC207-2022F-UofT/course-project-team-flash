/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains an interface named RunQuizInputBoundary with abstract methods startQuiz,
 * showProblem, and showAnswer.
 */

package runQuiz;

public interface RunQuizInputBoundary {

    StartQuizOutputData startQuiz(StartQuizInputData inputData);

    ShowProblemOutputData showProblem(ShowQuizCardInputData inputData);

    ShowAnswerOutputData showAnswer(ShowQuizCardInputData inputData);

}
