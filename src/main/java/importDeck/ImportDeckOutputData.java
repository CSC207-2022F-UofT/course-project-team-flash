/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;
import entities.Deck;

public class ImportDeckOutputData {
    private final String message;

    /**
     * Creates a data object for the deck import output.
     * @param message output message
     */
    public ImportDeckOutputData(String message){
        this.message = message;
    }
}
