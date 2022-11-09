/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;
import entities.Deck;
public class ImportDeckOutputData {
    private Deck importedDeck;

    public ImportDeckOutputData(Deck importedDeck){
        this.importedDeck = importedDeck;
    }
    public Deck getDeck(){
        return importedDeck;
    }
}
