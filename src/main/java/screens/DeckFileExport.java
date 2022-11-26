package screens;

import exportDeck.ExportDeckDsGateway;
import exportDeck.ExportDeckDsInputData;
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
            throw new RuntimeException(e);
        }
    }
}
