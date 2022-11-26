/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the presenter for the deck export system
 */

package exportDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class ExportDeckPresenter implements ExportDeckOutputBoundary{
    private final ViewBoundary viewBoundary;

    /**
     * Constructor for the deck export presenter
     * @param viewBoundary the view boundary
     */
    public ExportDeckPresenter(ViewBoundary viewBoundary){
        this.viewBoundary = viewBoundary;
    }

    /**
     * Should update UI informing the user the export was a success.
     * @param outputData the data created from the input
     */
    @Override
    public void prepareSuccessView(ExportDeckOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_EXPORTED)
                .setReturnString(outputData.getMessage())
                .build();
        viewBoundary.updateView(viewModel);
    }

    /**
     * Should update the UI informing the export failed.
     * @param exception the exception message
     */
    @Override
    public void prepareFailView(String exception) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(exception)
                .build();
        viewBoundary.updateView(viewModel);
    }
}
