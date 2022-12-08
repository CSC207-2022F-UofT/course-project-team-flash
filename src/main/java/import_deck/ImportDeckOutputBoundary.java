/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 9/22
 * This is the output boundary for the deck import system
 */

package import_deck;

public interface ImportDeckOutputBoundary {
    /**
     * Prepares the view if import succeeds.
     * @param outputData the output data created from the interactor
     */
    void prepareSuccessView(ImportDeckOutputData outputData);

    /**
     * Prepares the view if import fails.
     * @param error the error message
     */
    void prepareFailView(String error);
}