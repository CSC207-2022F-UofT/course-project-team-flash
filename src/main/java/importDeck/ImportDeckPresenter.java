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
     */
    @Override
    public void prepareSuccessView(ImportDeckOutputData outputData) {
        //do stuff to the UI showing the deck was imported
    }

    /**
     * Throws an exception stating the import failed
     * @param error the error message
     */
    @Override
    public void prepareFailView(String error) {
        //throw an error, maybe something like "Failed to import deck"
    }
}
