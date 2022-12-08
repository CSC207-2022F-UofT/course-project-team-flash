/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 25/22
 */

package data;

import export_deck.ExportDeckDsGateway;
import export_deck.ExportDeckDsInputData;
import screens.ExportDeckFail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This creates a file containing deck information to the filesystem
 */
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
            File deckFile = new File(deckFileName);
            boolean result = deckFile.getParentFile().mkdirs();
            System.out.println(result);
            FileWriter writer = new FileWriter(deckFile, false);
            for (String cardInfo : dsInputData.getDeckCards()) {
                writer.write(cardInfo + System.getProperty("line.separator"));
            }
            writer.close();
        }
        catch (IOException e){
            throw new ExportDeckFail(e.getMessage());
        }
    }
}
