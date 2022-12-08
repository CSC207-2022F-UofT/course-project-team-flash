/*
 * Author: Derrick Cho
 * Date: November 13/22
 */

package move_card;

import screens.ViewModel;
import screens.ViewState;
import screens.ViewBoundary;

/**
 * This file contains the implementation of the MoveCardPresenter class
 * It contains the instance attributes of MoveCardPresenter
 * and two methods prepareSuccessView and prepareFailView
 */
public class MoveCardPresenter implements MoveCardOutputBoundary{

    ViewBoundary viewBound;

    /**
     * Creates a new MoveCardPresenter with a given ViewBoundary
     * @param viewBound a ViewBoundary
     */
    public MoveCardPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Takes in a given MoveCardOutputData and returns a success view
     * @param moveCardOutputData a MoveCardOutputData
     */
    @Override
    public void prepareSuccessView(MoveCardOutputData moveCardOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.CARD_MOVED)
                .setReturnString(moveCardOutputData.getMessage())
                .setCardId(moveCardOutputData.getId())
                .build();
        viewBound.updateView(viewModel);
    }

    /**
     * Takes in a given MoveCardOutputData and returns a fail view
     * @param moveCardOutputData a MoveCardOutputData
     */
    @Override
    public void prepareFailView(MoveCardOutputData moveCardOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(moveCardOutputData.getMessage())
                .build();
        viewBound.updateView(viewModel);
    }
}
