/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the controller for the deck import system
 */

package importDeck;

public class ImportDeckController {
    private final ImportDeckInputBoundary importDeckInputBoundary;

    /**
     * A new ImportDeckController for the use case defined by ImportDeckInputBoundary
     * @param importDeckInputBoundary The input boundary for the deck import use case.
     */
    public ImportDeckController(ImportDeckInputBoundary importDeckInputBoundary){
        this.importDeckInputBoundary = importDeckInputBoundary;
    }

    public void runImport(){

    }
}
