/*
 * Author: Aldo Bani
 * Date November 26/22
 * This is the interactor test for the import deck use case
 */

package importDeck;

import data.DeckInMemoryImport;
import entities.CardFactory;
import entities.FlashcardFactory;
import exportDeck.ExportDeckInputData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ImportDeckInteractorTest {
    @Test
    void exportDeck(){
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport();
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){

            }

            @Override
            public void prepareFailView(String exception){

            }
        };
        CardFactory cardFactory = new FlashcardFactory();
        ImportDeckInputBoundary interactor = new ImportDeckInteractor(deckRepository, presenter, cardFactory);

        ImportDeckInputData inputData = new ImportDeckInputData("test");
        interactor.importDeck(inputData);
    }
}