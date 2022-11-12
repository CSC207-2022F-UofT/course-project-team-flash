/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the input data needed for the deck export system
 */

package exportDeck;

import entities.Deck;

public class ExportDeckInputData {
    private final Deck deckToExport;

    /**
     * Creates a data object for deck export input.
     * @param deckToExport the deck the user wants to export
     */
    public ExportDeckInputData(Deck deckToExport) {
        this.deckToExport = deckToExport;
    }

    /**
     * @return deck that user wants to export
     */
    public Deck getDeckToExport() {
        return deckToExport;
    }
}
