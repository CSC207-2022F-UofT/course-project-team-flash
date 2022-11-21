/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the output data needed for the deck import system
 */

package importDeck;

public class ImportDeckOutputData {
    private final String message;
    private final String importedDeckName;

    /**
     * Creates a data object for the deck import output.
     * @param message output message
     * @param importedDeckName name of deck created from file read
     */
    public ImportDeckOutputData(String message, String importedDeckName){
        this.message = message;
        this.importedDeckName = importedDeckName;
    }

    public String getImportedDeckName(){
        return importedDeckName;
    }
}
