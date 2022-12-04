/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */

package createQuiz;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

/**
 * This file contains the implementation of the CreateQuizPresenter,
 * which implements CreateQuizOutputBoundary.
 */
public class CreateQuizPresenter implements CreateQuizOutputBoundary{

    ViewBoundary viewBound;

    public CreateQuizPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view given outputData, if the quiz is created and stored successfully.
     *
     * @param outputData the CreateQuizOutputData associated with this created quiz
     */
    @Override
    public void prepareSuccessView(CreateQuizOutputData outputData){
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_CREATED).
                setQuizName(outputData.getQuizName()).build();
        viewBound.updateView(viewModel);
    }
    /**
     * Prepare the fail view given outputData, if the quiz cannot be created or stored successfully.
     *
     * @param outputData the CreateQuizOutputData associated with this created quiz
     */
    @Override
    public void prepareFailView(CreateQuizOutputData outputData){

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR).
                setReturnString(outputData.getMessage()).build();

        viewBound.updateView(viewModel);
    }

}
