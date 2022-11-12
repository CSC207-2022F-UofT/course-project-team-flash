/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the output boundary for the deck export system
 */

package exportDeck;

public interface ExportDeckOutputBoundary {
    ExportDeckOutputData prepareSuccessView(ExportDeckOutputData outputData);
    ExportDeckOutputData prepareFailView(String error);
}
