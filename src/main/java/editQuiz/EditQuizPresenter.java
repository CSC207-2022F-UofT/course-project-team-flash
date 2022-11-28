package editQuiz;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class EditQuizPresenter implements EditQuizOutputBoundary {

    ViewBoundary viewBound;

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
                .build();

        viewBound.updateView(viewModel);
    }

    @Override
    public void prepareFailView(EditQuizOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(outputData.getMessage())
                .build();

        viewBound.updateView(viewModel);
    }
}
