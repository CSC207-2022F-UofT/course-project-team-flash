package deleteDeck;

import screens.DeckNotFound;
import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary{

    ViewBoundary viewBound;

    public DeleteDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    @Override
    public void prepareSuccessView(DeleteDeckOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_DELETED)
                .setDeckName(outputData.getDeckName())
                .build();

        viewBound.updateView(viewModel);

    }

    @Override
    public void prepareFailView(String error) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString("Deck not found")
                .build();

        viewBound.updateView(viewModel);

    }
}
