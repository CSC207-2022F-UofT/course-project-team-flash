/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output boundary for the deck import system
 */

package importDeck;

public interface ImportDeckOutputBoundary {
    void prepareSuccessView(ImportDeckOutputData outputData);
    void prepareFailView(String error);
}