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

    public void runImport(String fileName){
        ImportDeckInputData inputData = new ImportDeckInputData(fileName);
    }
}
