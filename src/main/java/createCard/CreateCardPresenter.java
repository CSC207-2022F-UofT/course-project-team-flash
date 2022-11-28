/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateCardPresenter, which implements CreateCardOutputBoundary.
 */

package createCard;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class CreateCardPresenter implements CreateCardOutputBoundary {

    ViewBoundary viewBound;

    /**
     * Constructor function
     *
     * @param viewBound An instance of the view object's interface
     */
    public CreateCardPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view given outputData, if the card is created and stored successfully.
     *
     * @param outputData the CreateCardOutputData associated with this created quiz
     */
    @Override
    public void prepareSuccessView(CreateCardOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.CARD_CREATED)
                .setCardType(outputData.getType())
                .setCardQuestion(outputData.getQuestion())
                .setCardAnswer(outputData.getAnswer())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepare the fail view given outputData, if the card cannot be created or stored successfully.
     *
     * @param outputData the CreateCardOutputData associated with this created quiz
     */
    @Override
    public void prepareFailView(CreateCardOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(outputData.getMessage())
                .build();

        viewBound.updateView(viewModel);
    }
}
