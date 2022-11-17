/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;
import entities.Deck;

public class ImportDeckOutputData {
    private final String message;
    private final Deck importedDeck;

    /**
     * Creates a data object for the deck import output.
     * @param message output message
     * @param importedDeck deck created from file read
     */
    public ImportDeckOutputData(String message, Deck importedDeck){
        this.message = message;
        this.importedDeck = importedDeck;
    }

    public Deck getImportedDeck(){
        return importedDeck;
    }
}
