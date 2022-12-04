/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardPresenter
 */
package deleteCard;

import screens.ViewModel;
import screens.ViewBoundary;
import screens.ViewState;

/**
 * This file contains the implementation of the DeleteCardPresenter class
 * It contains the instance variables of DeleteCardPresenter
 * and contains two methods prepareSuccessView and prepareFailView
 */
public class DeleteCardPresenter implements DeleteCardOutputBoundary{

    ViewBoundary viewBoundary;

    /**
     * Creates a new DeleteCardPresenter with a given ViewBoundary
     * @param viewBoundary a ViewBoundary
     */
    public DeleteCardPresenter(ViewBoundary viewBoundary) {
        this.viewBoundary = viewBoundary;
    }

    /**
     * Takes in a given DeleteCardOutputData and prepares a success view
     * @param deleteCardOutputData a DeleteCardOutputData
     */
    @Override
    public void prepareSuccessView(DeleteCardOutputData deleteCardOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.CARD_DELETED)
                .setReturnString(deleteCardOutputData.getMessage())
                .setCardId(deleteCardOutputData.getId())
                .build();

        viewBoundary.updateView(viewModel);
    }

    /**
     * takes in a given DeleteCardOutputData and prepares a fail view
     * @param deleteCardOutputData a DeleteCardOutputData
     */
    @Override
    public void prepareFailView(DeleteCardOutputData deleteCardOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(deleteCardOutputData.getMessage())
                .build();

        viewBoundary.updateView(viewModel);
    }
}
