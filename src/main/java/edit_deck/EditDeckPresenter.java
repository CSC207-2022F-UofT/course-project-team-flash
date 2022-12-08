/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package edit_deck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class EditDeckPresenter implements EditDeckOutputBoundary{
    ViewBoundary viewBound;

    /**
     * Creates a new instance of the edit deck presenter
     * @param viewBound the view boundary
     */
    public EditDeckPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Should update UI letting user know the deck was edited.
     * @param editDeckOutputData the data from the interactor
     */
    @Override
    public void prepareSuccessView(EditDeckOutputData editDeckOutputData){
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_EDITED)
                .setDeckName(editDeckOutputData.getText())
                .setDeckName2(editDeckOutputData.getOldName())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Should update UI letting user know the deck could not be edited.
     * @param editDeckOutputData the data from the interactor
     */
    @Override
    public void prepareFailView(EditDeckOutputData editDeckOutputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(editDeckOutputData.getText())
                .build();

        viewBound.updateView(viewModel);
    }
}
