/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the use case interactor for the deck export system
 */

package exportDeck;

import entities.Deck;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportDeckInteractor implements ExportDeckInputBoundary{
    private final ExportDeckOutputBoundary exportDeckOutputBoundary;

    public ExportDeckInteractor(ExportDeckOutputBoundary exportDeckOutputBoundary) {
        this.exportDeckOutputBoundary = exportDeckOutputBoundary;
    }

    /**
     * Takes a deck and creates a file containing information about the deck and saves to user's filesystem
     * @param inputData data retrieved from the input
     */
    @Override
    public void exportDeck(ExportDeckInputData inputData) {
        try {
            String filePath = inputData.getFilePath();
            Deck deckToExport = inputData.getDeckToExport();
            String deckFileName = filePath + deckToExport.getName() + ".deck";
            File deckFile = new File(deckFileName);
            FileWriter writer = new FileWriter(deckFileName, false);
            //writer writes card information to the file...
            writer.close();
            boolean result = deckFile.createNewFile();
            String message;
            if (result) message = "File at " + deckFileName + " was created." ;
            else { message = "File at " + deckFileName + " was overwritten."; }
            ExportDeckOutputData outputData = new ExportDeckOutputData(message);
            exportDeckOutputBoundary.prepareSuccessView(outputData);
        }
        catch (IOException e){
            exportDeckOutputBoundary.prepareFailView(e.toString());
        }
    }
}
