/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output boundary for the deck import system
 */

package importDeck;

public interface ImportDeckOutputBoundary {
    ImportDeckOutputData prepareSuccessView(ImportDeckOutputData outputData);
    ImportDeckOutputData prepareFailView(String error);
}