/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.Deck;
import entities.Flashcard;
import entities.CardFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ImportDeckInteractor implements ImportDeckInputBoundary{
    private final ImportDeckOutputBoundary importDeckOutputBoundary;
    private final CardFactory cardFactory;

    /**
     * The interactor for the deck import use case
     * @param importDeckOutputBoundary The output boundary for the deck import use case.
     */
    public ImportDeckInteractor(ImportDeckOutputBoundary importDeckOutputBoundary, CardFactory cardFactory){
        this.importDeckOutputBoundary = importDeckOutputBoundary;
        this.cardFactory = cardFactory;
    }

    /**
     * Takes in data input containing the file and creates a data output with a deck containing its cards
     * @param inputData data retrieved from the input
     */
    @Override
    public ImportDeckOutputData importDeck(ImportDeckInputData inputData){
        try {
            File deckFile = new File(inputData.getFileName());
            Deck importedDeck = new Deck(deckFile.getName());
            Scanner reader = new Scanner(deckFile);
            while (reader.hasNextLine()){
                String cardInfo = reader.nextLine();
                String[] cardInfoArray = cardInfo.split(";");
                String[] options = cardInfoArray[3].split(",");
                Flashcard card = cardFactory.createCard(
                        Integer.parseInt(cardInfoArray[0]),
                        cardInfoArray[1],
                        cardInfoArray[2], Arrays.asList(options)
                );
                if (card != null){
                    importedDeck.addCard(card);
                }
            }
            reader.close();
            Deck.addTracker(importedDeck.getName(), importedDeck);
            ImportDeckOutputData outputData = new ImportDeckOutputData("Imported the deck!");
            return importDeckOutputBoundary.prepareSuccessView(outputData);
        }
        catch (FileNotFoundException e){
            return importDeckOutputBoundary.prepareFailView(e.toString());
        }
    }
}
