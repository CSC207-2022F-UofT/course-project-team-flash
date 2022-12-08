/**
 * Author: Jamie Chew
 * Documentation Author: Jamie Chew
 * Date: December 7th, 2022
 *
 * This file contains the RunQuizPresenter class. This includes a constructor
 * that takes in a ViewBoundary, 3 prepareSuccessView methods (one each for: startQuiz,
 * showProblem, and showAnswer), and 1 fail view.
 */
package runQuiz;

import screens.*;

public class RunQuizPresenter implements RunQuizOutputBoundary {

    private final ViewBoundary viewBound;

    /**
     * Creates a RunQuizPresenter object given a ViewBoundary object.
     *
     * @param viewBound the interface between this presenter and the view.
     */
    public RunQuizPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepares the success view given a ShowAnswerOutputData, if the quiz exists.
     *
     * @param outputData the ShowAnswerOutputData associated with this problem
     */
    @Override
    public void prepareSuccessView(ShowAnswerOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_ANSWER)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setUserAnswer(outputData.getUserAnswer())
                .setCardAnswer(outputData.getCurrCardAnswer())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepares the success view given a ShowProblemOutputData, if the quiz exists.
     *
     * @param outputData the ShowProblemOutputData associated with this problem
     */
    @Override
    public void prepareSuccessView(ShowProblemOutputData outputData) {

        if (outputData.noMoreProblems()) {
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_MENU)
                    .setReturnString("End of quiz!")
                    .build();

            viewBound.updateView(viewModel);
        } else {
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                    .setCardIdArray(outputData.getFlashcardIdList())
                    .setCurrCardIndex(outputData.getCurrCardIndex())
                    .setReturnString(outputData.getCurrCardQuestion())
                    .setCardAnswer(outputData.getCurrCardAnswer())
                    .setCardOptions(outputData.getCardOptions())
                    .build();

            viewBound.updateView(viewModel);
        }

    }

    /**
     * Prepares the success view given a StartQuizOutputData, if the quiz exists.
     *
     * @param outputData the StartQuizOutputData associated with this quiz
     */
    @Override
    public void prepareSuccessView(StartQuizOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setReturnString(outputData.getFirstCardProblem())
                .setCardAnswer(outputData.getFirstCardAnswer())
                .setCardOptions(outputData.getFirstCardOptions())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepare the fail view with the error string given.
     *
     * @param error the description of this error
     */
    public void quizFailView(String error) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(error)
                .build();

        viewBound.updateView(viewModel);
    }
}
