package deleteDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary{
    ViewBoundary viewBound;

    /**
     * Creates a new instance of the presenter
     * @param viewBound the view boundary
     */
    public DeleteDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    /**
     * Should update the UI letting the user know the deck was deleted.
     * @param outputData the output data created from the interactor
     */
    @Override
    public void prepareSuccessView(DeleteDeckOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_DELETED)
                .setDeckName(outputData.getDeckName())
                .build();

        viewBound.updateView(viewModel);

    }

    /**
     * Should update the UI letting the user know the deck could not be deleted (for whatever reason).
     * @param error the error message
     */
    @Override
    public void prepareFailView(String error) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(error)
                .build();

        viewBound.updateView(viewModel);

    }
}
