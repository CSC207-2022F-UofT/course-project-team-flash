/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 25/22
 * This is the input data for the gateway
 */

package exportDeck;

import java.util.List;

public class ExportDeckDsInputData {
    private final String fileLocation;
    private final String deckExportName;
    private final List<String> deckCards;

    /**
     * Constructor for the input data needed for the gateway.
     * @param fileLocation where the deck is to be saved
     * @param deckName name of the deck
     * @param deckCards card information from the deck
     */
    public ExportDeckDsInputData(String fileLocation, String deckName, List<String> deckCards) {
        this.fileLocation = fileLocation;
        this.deckExportName = deckName;
        this.deckCards = deckCards;
    }

    /**
     * @return the file location.
     */
    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * @return the deck name.
     */
    public String getDeckExportName() {
        return deckExportName;
    }

    /**
     * @return returns a list containing information about the deck's cards.
     */
    public List<String> getDeckCards() {
        return deckCards;
    }
}
