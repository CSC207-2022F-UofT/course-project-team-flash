package createDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class CreateDeckPresenter implements CreateDeckOutputBoundary {

    ViewBoundary viewBound;

    public CreateDeckPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }
    @Override
    public void prepareSuccessView(CreateDeckOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_CREATED)
                .setDeckName(outputData.getDeckName())
                .build();

        viewBound.updateView(viewModel);

    }

    @Override
    public void prepareFailView(CreateDeckOutputData outputData) {
    }
}
