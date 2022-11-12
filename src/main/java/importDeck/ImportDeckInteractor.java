/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.Deck;
import entities.Flashcard;
//import entities.FlashcardFactory;


public class ImportDeckInteractor implements ImportDeckInputBoundary{
    final ImportDeckController importDeckController;
    final ImportDeckPresenter importDeckPresenter;
    //final FlashcardFactory flashcardFactory;

    public ImportDeckInteractor(ImportDeckController importDeckController, ImportDeckPresenter importDeckPresenter
            /*, FlashcardFactory flashcardFactory*/){
        this.importDeckController = importDeckController;
        this.importDeckPresenter = importDeckPresenter;
        //this.flashcardFactory = flashcardFactory;
    }

    /**
     * Takes in the file name and file contents and creates a deck containing cards
     * @param inputData data retrieved from the input
     * @return an OutputData object (for ImportDeck) containing a message and the deck
     */
    @Override
    public ImportDeckOutputData importDeck(ImportDeckInputData inputData){
        Deck importedDeck = new Deck(inputData.getFileName());
        //something with reading filecontents and adding cards to the deck
        return new ImportDeckOutputData("test", importedDeck);
    }
}
