/*
 * Author: Aldo Bani
 * Date November 26/22
 * This is the interactor test for the export deck use case
 */

package exportDeck;

import data.DeckInMemoryExport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.Deck;

public class ExportDeckInteractorTest {
    @Test
    void exportDeck(){
        Deck d1 = new Deck("Test");
        Deck.addTracker(d1.getName(), d1);
        ExportDeckDsGateway deckRepository = new DeckInMemoryExport();
        ExportDeckOutputBoundary presenter = new ExportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ExportDeckOutputData outputData){
                Assertions.assertEquals("Test was exported to: home/decks/Test.deck", outputData.getMessage());
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.fail(exception);
            }
        };
        ExportDeckInputBoundary interactor = new ExportDeckInteractor(deckRepository, presenter);

        ExportDeckInputData inputData = new ExportDeckInputData("home/decks/", "Test");
        interactor.exportDeck(inputData);
    }

    @Test
    void exportNonExistingDeck(){
        ExportDeckDsGateway deckRepository = new DeckInMemoryExport();
        ExportDeckOutputBoundary presenter = new ExportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ExportDeckOutputData outputData){
                Assertions.fail("Should not be able to export non-existing deck");
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.assertEquals("Cannot export, selected deck does not exist!" ,exception);
            }
        };
        ExportDeckInputBoundary interactor = new ExportDeckInteractor(deckRepository, presenter);

        ExportDeckInputData inputData = new ExportDeckInputData("home/decks/", "Test2");
        interactor.exportDeck(inputData);
    }
}
