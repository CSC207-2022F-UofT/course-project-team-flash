/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the presenter for the deck import system
 */

package importDeck;

public class ImportDeckPresenter implements ImportDeckOutputBoundary {

    /**
     * Should update UI informing the user the import was a success
     * @param outputData the data created from the input
     * @return the output data
     */
    @Override
    public ImportDeckOutputData prepareSuccessView(ImportDeckOutputData outputData) {
        //do stuff to the UI showing the deck was imported
        return outputData;
    }

    /**
     * Throws an exception stating the import failed
     * @param error the error message
     * @return null
     */
    @Override
    public ImportDeckOutputData prepareFailView(String error) {
        //throw an error, maybe something like "Failed to import deck"
        return null;
    }
}
