package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * The presenter class for edit card systems
 */

import createDeck.CreateDeckOutputData;
import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

/**
 * This file contains the implementation of the EditCardPresenter,
 * which implements EditCardOutputBoundary.
 */
public class EditCardPresenter implements EditCardOutputBoundary {

    /**
     * Creates a new EditCardPresenter
     */
    ViewBoundary viewBound;

    public EditCardPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    /**
     * Prepare the success view of the given EditCardOutputData
     * @param editCardOutputData an EditCardOutputData
     */
    @Override
    public void prepareSuccessView(EditCardOutputData editCardOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.CARD_EDITED)
                .build();

        viewBound.updateView(viewModel);
    }

}
