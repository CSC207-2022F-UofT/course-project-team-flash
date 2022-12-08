/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 */
package edit_quiz;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class EditQuizPresenter implements EditQuizOutputBoundary {

    ViewBoundary viewBound;

    /**
     * Construct EditQuizPresenter with its corresponding view interface
     *
     * @param viewBound an interface of the view
     */
    public EditQuizPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view given outputData, when the quiz has been edited
     *
     * @param outputData the EditQuizOutputData associated with this edited quiz
     */
    @Override
    public void prepareSuccessView(EditQuizOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_EDITED)
                .setQuizName(outputData.getMessage())
                .setQuizName2(outputData.getOldName())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepare the fail view given outputData, when the quiz has been edited
     *
     * @param outputData the EditQuizOutputData associated with this edited quiz
     */
    @Override
    public void prepareFailView(EditQuizOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(outputData.getMessage())
                .build();

        viewBound.updateView(viewModel);
    }
}
