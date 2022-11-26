/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the output boundary for the deck export system
 */

package exportDeck;

public interface ExportDeckOutputBoundary {
    /**
     * Prepares the view if export succeeds.
     * @param outputData the output data created from the interactor
     */
    void prepareSuccessView(ExportDeckOutputData outputData);

    /**
     * Prepares the view if export failed.
     * @param error the error message if export failed.
     */
    void prepareFailView(String error);
}
