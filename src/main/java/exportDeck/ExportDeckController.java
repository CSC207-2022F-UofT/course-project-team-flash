/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the controller for the deck export system
 */

package exportDeck;

import entities.Deck;
import entities.Flashcard;

public class ExportDeckController {
    private final ExportDeckInputBoundary exportDeckInputBoundary;

    /**
     * A new ExportDeckController for the use case defined by ExportDeckInputBoundary
     * @param exportDeckInputBoundary The input boundary for the deck export use case.
     */
    public ExportDeckController(ExportDeckInputBoundary exportDeckInputBoundary) {
        this.exportDeckInputBoundary = exportDeckInputBoundary;
    }

    public void runExport(String filePath, String deckToExportName){
        ExportDeckInputData inputData = new ExportDeckInputData(filePath, deckToExportName);
        exportDeckInputBoundary.exportDeck(inputData);
    }
}
