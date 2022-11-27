/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 9/22
 * This is the presenter for the deck import system
 */

package importDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

public class ImportDeckPresenter implements ImportDeckOutputBoundary {
    private final ViewBoundary viewBoundary;

    /**
     * Constructor for the presenter
     * @param viewBoundary the view boundary
     */
    public ImportDeckPresenter(ViewBoundary viewBoundary){
        this.viewBoundary = viewBoundary;
    }

    /**
     * Should update UI informing the user the import was a success
     * @param outputData the data created from the input
     */
    @Override
    public void prepareSuccessView(ImportDeckOutputData outputData) {
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_IMPORTED)
                .setDeckName(outputData.getImportedDeckName())
                .build();
        viewBoundary.updateView(viewModel);
    }

    /**
     * Throws an exception stating the import failed
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
