/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.Deck;
import entities.Flashcard;

public class ImportDeckInteractor implements ImportDeckInputBoundary{
    final ImportDeckController importDeckController;
    final ImportDeckPresenter importDeckPresenter;

    //deck and card factory needed maybe??

    public ImportDeckInteractor(ImportDeckController importDeckController, ImportDeckPresenter importDeckPresenter){
        this.importDeckController = importDeckController;
        this.importDeckPresenter = importDeckPresenter;
    }
    @Override
    public ImportDeckOutputData importDeck(ImportDeckInputData inputData){

    }
}
