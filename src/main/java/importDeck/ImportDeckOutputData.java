/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;
import entities.Deck;

public class ImportDeckOutputData {
    private String message;
    private Deck importedDeck;

    /**
     * Creates a data object for the deck import output.
     * @param message output message
     * @param importedDeck the deck created from the input
     */
    public ImportDeckOutputData(String message, Deck importedDeck){
        this.message = message;
        this.importedDeck = importedDeck;
    }

    /**
     * @return the deck object
     */
    public Deck getDeck(){
        return importedDeck;
    }
}
