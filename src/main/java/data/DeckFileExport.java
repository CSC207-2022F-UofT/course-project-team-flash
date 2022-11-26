package data;

import exportDeck.ExportDeckDsGateway;
import exportDeck.ExportDeckDsInputData;
import screens.ExportDeckFail;

import java.io.FileWriter;
import java.io.IOException;

public class DeckFileExport implements ExportDeckDsGateway{
    @Override
    public void export(ExportDeckDsInputData dsInputData){
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
