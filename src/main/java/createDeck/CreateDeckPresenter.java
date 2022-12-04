/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */
package createDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

/**
 * This file contains the implementation of the presenter, which calls the view through an interface
 */
public class CreateDeckPresenter implements CreateDeckOutputBoundary {

    ViewBoundary viewBound;

    public CreateDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view given outputData, when the deck has been created
     *
     * @param outputData the EditQuizOutputData associated with this edited quiz
     */
    @Override
    public void prepareSuccessView(CreateDeckOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_CREATED)
                .setDeckName(outputData.getText())
                .build();

        viewBound.updateView(viewModel);

    }
    /**
     * Prepare the fail view given outputData, when the deck failed to be created
     *
     * @param outputData the EditQuizOutputData associated with this edited quiz
     */
    @Override
    public void prepareFailView(CreateDeckOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(outputData.getText())
                .build();

        viewBound.updateView(viewModel);
    }
}
