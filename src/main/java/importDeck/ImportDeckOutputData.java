/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;

public class ImportDeckOutputData {
    private final String importedDeckName;

    /**
     * Creates a data object for the deck import output.
     * @param importedDeckName name of deck created from file read
     */
    public ImportDeckOutputData(String importedDeckName){
        this.importedDeckName = importedDeckName;
    }

    /**
     * @return the name of the imported deck
     */
    public String getImportedDeckName(){
        return importedDeckName;
    }
}
