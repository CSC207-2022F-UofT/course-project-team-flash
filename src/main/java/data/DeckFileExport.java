/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 25/22
 * This creates a file containing deck information to the filesystem
 */

package data;

import exportDeck.ExportDeckDsGateway;
import exportDeck.ExportDeckDsInputData;
import screens.ExportDeckFail;
import java.io.FileWriter;
import java.io.IOException;

public class DeckFileExport implements ExportDeckDsGateway{

    /**
     * Creates/overwrites a file in the given filepath with the name of the deck,
     * then writes card information to that file.
     * @param dsInputData the input data for the gateway
     */
    @Override
    public void exportToFile(ExportDeckDsInputData dsInputData){
        try {
            String deckFileName = dsInputData.getFileLocation() + dsInputData.getDeckExportName() + ".deck";
            FileWriter writer = new FileWriter(deckFileName, false);
            for (String cardInfo : dsInputData.getDeckCards()) {
                writer.write(cardInfo + System.getProperty("line.separator"));
            }
            writer.close();
        }
        catch (IOException e){
            throw new ExportDeckFail(e.toString());
        }
    }
}
