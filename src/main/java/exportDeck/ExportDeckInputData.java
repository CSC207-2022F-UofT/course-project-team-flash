/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the input data needed for the deck export system
 */

package exportDeck;

public class ExportDeckInputData {
    private final String filePath;
    private final String deckToExportName;

    /**
     * Creates a data object for deck export input.
     * @param filePath where the user wants to export the deck
     * @param deckToExportName the deck the user wants to export
     */
    public ExportDeckInputData(String filePath, String deckToExportName) {
        this.filePath = filePath;
        this.deckToExportName = deckToExportName;
    }

    /**
     * @return deck that user wants to export
     */
    public String getDeckToExportName() {
        return deckToExportName;
    }

    /**
     * @return the location where the user wants to save the deck
     */
    public String getFilePath() { return filePath; }
}
