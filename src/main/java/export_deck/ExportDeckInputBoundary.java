/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 12/22
 * This is the input boundary for the deck export system
 */

package export_deck;

public interface ExportDeckInputBoundary {
    /**
     * Formats the data for file writing
     * @param inputData the input data from the controller
     */
    void exportDeck(ExportDeckInputData inputData);
}
