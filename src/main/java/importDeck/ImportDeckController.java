/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the controller for the deck import system
 */

package importDeck;

public class ImportDeckController {
    private final ImportDeckInputBoundary importDeckInputBoundary;

    /**
     * The controller for the deck import use case
     * @param importDeckInputBoundary The input boundary for the deck import use case
     */
    public ImportDeckController(ImportDeckInputBoundary importDeckInputBoundary){
        this.importDeckInputBoundary = importDeckInputBoundary;
    }

    /**
     * Imports a deck from the filesystem.
     * @param fileName the name of the file that contains the deck information.
     */
    public void importDeck(String fileName){
        ImportDeckInputData inputData = new ImportDeckInputData(fileName);
        importDeckInputBoundary.importDeck(inputData);
    }
}
