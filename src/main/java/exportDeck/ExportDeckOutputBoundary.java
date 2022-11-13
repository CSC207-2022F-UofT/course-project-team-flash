/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the output boundary for the deck export system
 */

package exportDeck;

public interface ExportDeckOutputBoundary {
    void prepareSuccessView(ExportDeckOutputData outputData);
    void prepareFailView(String error);
}
