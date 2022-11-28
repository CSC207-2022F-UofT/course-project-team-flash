package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class EditDeckPresenter implements EditDeckOutputBoundary{

    ViewBoundary viewBound;

    public EditDeckPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    @Override
    public void prepareSuccessView(EditDeckOutputData editDeckOutputData){
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_EDITED).setDeckName(editDeckOutputData.getMessage()).build();

        viewBound.updateView(viewModel);
    }

    @Override
    public void prepareFailView(EditDeckOutputData editDeckOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(editDeckOutputData.getMessage())
                .build();

        viewBound.updateView(viewModel);
    }
}
