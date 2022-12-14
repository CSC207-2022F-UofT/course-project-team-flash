/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 9/22
 * This is the input boundary for the deck import system
 */

package import_deck;

public interface ImportDeckInputBoundary {
    /**
     * Reads a file and creates deck and its cards
     * @param inputData the input data from the controller
     */
    void importDeck(ImportDeckInputData inputData);
}
