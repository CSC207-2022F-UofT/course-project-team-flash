package deleteDeck;

import screens.DeckNotFound;
import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary{

    ViewBoundary viewBound;

    DeleteDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    @Override
    public void prepareSuccessView(DeleteDeckOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_DELETED)
                .setDeckName(outputData.deckName)
                .build();

        viewBound.updateView(viewModel);


    }

    @Override
    public void prepareFailView(String error) {
        throw new DeckNotFound(error);
    }
}
