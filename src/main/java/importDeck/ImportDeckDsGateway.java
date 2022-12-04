/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 * This is the gateway for the import system
 */

package importDeck;

public interface ImportDeckDsGateway {
    /**
     * Reads from a file containing information about a deck
     * @param dsInputData the input data for the gateway
     */
    ImportDeckDsOutputData importFromFile(ImportDeckDsInputData dsInputData);
}
