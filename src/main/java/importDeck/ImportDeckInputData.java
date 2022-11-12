/*
* Author: Aldo Bani
* Date: November 9/22
* This is the input data needed for the deck import system
*/

package importDeck;

public class ImportDeckInputData {
    private final String fileName;

    /**
     * Creates a data object for deck import input.
     * @param fileName name of the file
     */
    public ImportDeckInputData(String fileName){
        this.fileName = fileName;
    }

    /**
     * @return name of the file
     */
    String getFileName(){ return fileName; }
}
