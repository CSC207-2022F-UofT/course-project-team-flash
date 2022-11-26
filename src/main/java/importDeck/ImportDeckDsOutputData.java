/*
 * Author: Aldo Bani
 * Date: November 26/22
 * This is the output data for the gateway
 */

package importDeck;

import java.util.List;

public class ImportDeckDsOutputData {
    private final String importedDeckName;
    private final List<String> importedCards;

    /**
     * Constructs output data from the gateway
     * @param importedDeckName name of the deck that was imported
     * @param importedCards list of the cards imported
     */
    public ImportDeckDsOutputData(String importedDeckName, List<String> importedCards){
        this.importedDeckName = importedDeckName;
        this.importedCards = importedCards;
    }

    /**
     * @return name of the imported deck
     */
    public String getImportedDeckName(){
        return importedDeckName;
    }

    /**
     * @return list of the imported cards
     */
    public List<String> getImportedCards(){
        return importedCards;
    }
}
