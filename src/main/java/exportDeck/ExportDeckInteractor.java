/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the use case interactor for the deck export system
 */

package exportDeck;

import entities.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportDeckInteractor implements ExportDeckInputBoundary{
    private final ExportDeckOutputBoundary exportDeckOutputBoundary;

    /**
     * The interactor for the deck export use case
     * @param exportDeckOutputBoundary output boundary
     */
    public ExportDeckInteractor(ExportDeckOutputBoundary exportDeckOutputBoundary) {
        this.exportDeckOutputBoundary = exportDeckOutputBoundary;
    }

    /**
     * Gets the type of flashcard, returns -1 if invalid
     * @param card the card to be checked
     * @return numeric identifier for the card
     */
    private String getCardType(Flashcard card){
        if (card instanceof QandAFlashcard){
            return "1";
        }
        if (card instanceof MCFlashcard){
            return "2";
        }
        if (card instanceof SelectAllFlashcard){
            return "3";
        }
        return "-1";
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
            List<Flashcard> deckCards = deckToExport.getCards();
            String deckFileName = filePath + deckToExport.getName() + ".deck";
            File deckFile = new File(deckFileName);
            FileWriter writer = new FileWriter(deckFileName, false);
            for (Flashcard card : deckCards){
                String cardType = getCardType(card);
                if (cardType.equals("-1")){continue;}
                String cardInfo = cardType + ";" + card.getQuestion() + ";" + card.getAnswer();
                if (cardType.equals("2")){
                    String optionInfo = ";";
                    for (String option : ((MCFlashcard)card).getOptions()){
                        optionInfo = optionInfo.concat(option+",");
                    }
                    cardInfo = cardInfo.concat(optionInfo);
                }
                writer.write(cardInfo + System.getProperty("line.separator"));
            }
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
