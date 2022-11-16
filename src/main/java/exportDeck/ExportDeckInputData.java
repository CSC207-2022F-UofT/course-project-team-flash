/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the input data needed for the deck export system
 */

package exportDeck;

import entities.Deck;

public class ExportDeckInputData {
    private final String filePath;
    private final Deck deckToExport;

    /**
     * Creates a data object for deck export input.
     * @param filePath where the user wants to export the deck
     * @param deckToExport the deck the user wants to export
     */
    public ExportDeckInputData(String filePath, Deck deckToExport) {
        this.filePath = filePath;
        this.deckToExport = deckToExport;
    }

    /**
     * @return deck that user wants to export
     */
    public Deck getDeckToExport() {
        return deckToExport;
    }

    /**
     * @return the location where the user wants to save the deck
     */
    public String getFilePath() { return filePath; }
}
