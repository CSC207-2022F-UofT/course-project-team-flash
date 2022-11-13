/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the presenter for the deck export system
 */

package exportDeck;

public class ExportDeckPresenter implements ExportDeckOutputBoundary{
    /**
     * Should update UI informing the user the export was a success
     * @param outputData the data created from the input
     */
    @Override
    public void prepareSuccessView(ExportDeckOutputData outputData) {
        //do stuff to the UI showing the deck was exported
    }

    /**
     * Throws an exception stating the export failed
     * @param error the error message
     */
    @Override
    public void prepareFailView(String error) {
        //throw an error, maybe something like "Failed to export deck"
    }
}
