/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 */

package deleteQuiz;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

/**
 * This file contains the implementation of the DeleteQuizPresenter,
 * which implements DeleteQuizOutputBoundary.
 */
public class DeleteQuizPresenter implements DeleteQuizOutputBoundary{

    ViewBoundary viewBound;

    public DeleteQuizPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view given outputData, if the quiz is deleted successfully.
     *
     * @param outputData the DeleteQuizOutputData associated with the quiz to be deleted
     */
    @Override
    public void prepareSuccessView(DeleteQuizOutputData outputData){
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_DELETED).
                setQuizName(outputData.getQuizName()).build();
        viewBound.updateView(viewModel);
    }
    /**
     * Prepare the fail view given outputData, if the quiz cannot be deleted successfully.
     *
     * @param outputData the DeleteQuizOutputData associated with the quiz to be deleted
     */
    @Override
    public void prepareFailView(DeleteQuizOutputData outputData){

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR).
                setReturnString(outputData.getMessage()).build();

        viewBound.updateView(viewModel);
    }

}
