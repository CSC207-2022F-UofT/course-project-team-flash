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

    public ImportDeckOutputData(String message, Deck importedDeck){
        this.message = message;
        this.importedDeck = importedDeck;
    }
    public Deck getDeck(){
        return importedDeck;
    }
}
