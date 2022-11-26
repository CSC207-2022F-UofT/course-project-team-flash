/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the use case interactor for the deck export system
 */

package exportDeck;

import entities.*;

import java.util.ArrayList;
import java.util.List;

public class ExportDeckInteractor implements ExportDeckInputBoundary{
    private final ExportDeckOutputBoundary exportDeckOutputBoundary;
    private final ExportDeckDsGateway exportDeckDsGateway;

    /**
     * The interactor for the deck export use case
     * @param exportDeckOutputBoundary output boundary
     */
    public ExportDeckInteractor(ExportDeckDsGateway exportDeckDsGateway, ExportDeckOutputBoundary exportDeckOutputBoundary) {
        this.exportDeckOutputBoundary = exportDeckOutputBoundary;
        this.exportDeckDsGateway = exportDeckDsGateway;
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
        String filePath = inputData.getFilePath();
        String deckToExportName = inputData.getDeckToExportName();
        Deck deckToExport = Deck.getTracker().get(deckToExportName);
        List<String> deckCards = new ArrayList<>();
        for (Flashcard card : deckToExport.getCards()){
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
            deckCards.add(cardInfo);
        }
        ExportDeckDsInputData exportDeckDsInputData = new ExportDeckDsInputData(filePath, deckToExportName, deckCards);
        exportDeckDsGateway.export(exportDeckDsInputData);
        ExportDeckOutputData outputData = new ExportDeckOutputData("Deck was exported.");
        exportDeckOutputBoundary.prepareSuccessView(outputData);
    }
}
