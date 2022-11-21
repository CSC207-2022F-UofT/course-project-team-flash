/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the presenter for the deck import system
 */

package importDeck;

/*
import screens.ImportFailScreen;
import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;
*/
public class ImportDeckPresenter implements ImportDeckOutputBoundary {
    /*
    private ViewModel viewModel;

    public ImportDeckPresenter(ViewModel viewModel){
        this.viewModel = viewModel;
    }
    */

    /**
     * Should update UI informing the user the import was a success
     * @param outputData the data created from the input
     */
    @Override
    public void prepareSuccessView(ImportDeckOutputData outputData) {
        /*
        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.DECK_IMPORTED)
                .setDeckName(outputData.deckName)
                .build();

        viewBound.updateView(viewModel);
        */
    }

    /**
     * Throws an exception stating the import failed
     * @param error the error message
     */
    @Override
    public void prepareFailView(String error) {

    }
}
