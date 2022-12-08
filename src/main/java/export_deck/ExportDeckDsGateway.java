/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 25/22
 * This is the gateway for the export system
 */

package export_deck;

public interface ExportDeckDsGateway {
    /**
     * Writes information in the input data to a file
     * @param dsInputData the input data for the gateway
     */
    void exportToFile(ExportDeckDsInputData dsInputData);
}
