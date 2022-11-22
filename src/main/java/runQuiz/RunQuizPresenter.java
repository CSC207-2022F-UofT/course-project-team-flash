/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the RunQuizPresenter,
 * which implements RunQuizOutputBoundary.
 */

package runQuiz;

import screens.ViewState;
import screens.QuizNotFound;

public class RunQuizPresenter implements RunQuizOutputBoundary {

    /**
     * Prepares the success view given a ShowAnswerOutputData, if the quiz exists.
     *
     * @param outputData the ShowAnswerOutputData associated with this problem
     */
    @Override
    public ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData) {
        outputData.setViewState(ViewState.SHOW_PROBLEM);

        return outputData;
    }

    /**
     * Prepares the success view given a ShowProblemOutputData, if the quiz exists.
     *
     * @param outputData the ShowProblemOutputData associated with this problem
     */
    @Override
    public ShowProblemOutputData prepareSuccessView(ShowProblemOutputData outputData) {

        if(outputData.noMoreProblems()){
            outputData.setViewState(ViewState.QUIZ_MENU);
        }
        else {
            outputData.setViewState(ViewState.SHOW_ANSWER);
        }

        return outputData;

    }

    /**
     * Prepares the success view given a StartQuizOutputData, if the quiz exists.
     *
     * @param outputData the StartQuizOutputData associated with this quiz
     */
    @Override
    public StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData) {
        outputData.setViewState(ViewState.SHOW_PROBLEM);

        return outputData;
    }

    /**
     * Prepare the fail view given outputData, if the quiz does not exist.
     *
     * @param error the description of this error
     */
    public StartQuizOutputData quizFailView(String error){
        throw new QuizNotFound(error);
    }
}
