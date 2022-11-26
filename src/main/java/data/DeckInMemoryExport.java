/*
 * Author: Aldo Bani
 * Date: November 26/22
 * This is supposed to be used for testing file export
 */

package data;

import exportDeck.ExportDeckDsGateway;
import exportDeck.ExportDeckDsInputData;
import java.util.HashMap;
import java.util.Map;

public class DeckInMemoryExport implements ExportDeckDsGateway{
    final private Map<String, ExportDeckDsInputData> memoryDeckDirectory = new HashMap<>();

    /**
     * Puts the gateway input data into a map
     * @param dsInputData the input data for the gateway
     */
    @Override
    public void export(ExportDeckDsInputData dsInputData){
        System.out.println("Exported to" + dsInputData.getFileLocation()+dsInputData.getDeckExportName() + ".deck");
        memoryDeckDirectory.put(dsInputData.getDeckExportName() + ".deck", dsInputData);
    }
}
