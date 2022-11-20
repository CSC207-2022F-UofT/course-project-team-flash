package deleteDeck;

import screens.DeckNotFound;
import screens.ViewBoundary;
import screens.viewStates;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary{

    ViewBoundary viewBound;

    DeleteDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    @Override
    public void prepareSuccessView(DeleteDeckOutputData outputData) {
        viewBound.setViewState(viewStates.DECK_DELETED);

        viewBound.storeDeckName(outputData.deckName);
    }

    @Override
    public void prepareFailView(String error) {
        throw new DeckNotFound(error);
    }
}
