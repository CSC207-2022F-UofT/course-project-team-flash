/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.Deck;
import entities.Flashcard;
//import entities.FlashcardFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportDeckInteractor implements ImportDeckInputBoundary{
    private final ImportDeckOutputBoundary importDeckOutputBoundary;
    //private final CardFactory cardFactory;

    /**
     * The interactor for the deck import use case
     * @param importDeckOutputBoundary The output boundary for the deck import use case.
     */
    public ImportDeckInteractor(ImportDeckOutputBoundary importDeckOutputBoundary/*, CardFactory cardFactory*/){
        this.importDeckOutputBoundary = importDeckOutputBoundary;
        //this.flashcardFactory = flashcardFactory;
    }

    /**
     * Takes in data input containing the file and creates a data output with a deck containing its cards
     * @param inputData data retrieved from the input
     */
    @Override
    public void importDeck(ImportDeckInputData inputData){
        try {
            File deckFile = new File(inputData.getFileName());
            Deck importedDeck = new Deck(deckFile.getName(), /*temporary*/null);
            Scanner reader = new Scanner(deckFile);
            while (reader.hasNextLine()){
                String cardInfo = reader.nextLine();
                //TBD: functionality for flashcard creation and adding to the deck
            }
            reader.close();
            ImportDeckOutputData outputData = new ImportDeckOutputData("Imported the deck!", importedDeck);
            importDeckOutputBoundary.prepareSuccessView(outputData);
        }
        catch (FileNotFoundException e){
            importDeckOutputBoundary.prepareFailView(e.toString());
        }
    }
}
