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
            Deck deckToExport = inputData.getDeckToExport();
            String deckFileName = "temp"; //SHOULD ACTUALLY BE deckToExport.getName() + ".txt"
            File deckFile = new File(deckFileName);
            deckFile.createNewFile();
            FileWriter writer = new FileWriter(deckFileName);
            //writer writes card information to the file...
            writer.close();
            ExportDeckOutputData outputData = new ExportDeckOutputData("Deck exported!");
            exportDeckOutputBoundary.prepareSuccessView(outputData);
        }
        catch (IOException e){
            exportDeckOutputBoundary.prepareFailView(e.toString());
        }
    }
}
