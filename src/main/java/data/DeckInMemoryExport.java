/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 */

package data;

import export_deck.ExportDeckDsGateway;
import export_deck.ExportDeckDsInputData;

import java.util.HashMap;
import java.util.Map;

/**
 * This is supposed to be used for testing file export
 */
public class DeckInMemoryExport implements ExportDeckDsGateway{
    public static Map<String, ExportDeckDsInputData> memoryDeckDirectory = new HashMap<>();

    /**
     * Puts the gateway input data into a map
     * @param dsInputData the input data for the gateway
     */
    @Override
    public void exportToFile(ExportDeckDsInputData dsInputData){
        System.out.println("Exported to" + dsInputData.getFileLocation()+dsInputData.getDeckExportName() + ".deck");
        memoryDeckDirectory.put(dsInputData.getDeckExportName() + ".deck", dsInputData);
    }
}
