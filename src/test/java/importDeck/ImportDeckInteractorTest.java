/*
 * Author: Aldo Bani
 * Date November 26/22
 * This is the interactor test for the import deck use case
 */

package importDeck;

import data.DeckInMemoryImport;
import entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportDeckInteractorTest {
    @Test
    void importDeck(){
        Map<String, List<String>> files = new HashMap<>();
        List<String> fileContents = new ArrayList<>();
        fileContents.add("1;Did you pass?;No");
        files.put("Test", fileContents);
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Deck actual = Deck.getTracker().get(outputData.getImportedDeckName());
                Assertions.assertEquals("Test", actual.getName());
                List<Flashcard> actualCards = actual.getCards();
                Flashcard actualCard = actualCards.get(0);
                Assertions.assertTrue(actualCard instanceof QandAFlashcard);
                Assertions.assertEquals("Did you pass?", actualCard.getQuestion());
                Assertions.assertEquals("No", actualCard.getAnswer());
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.fail(exception);
            }
        };
        CardFactory cardFactory = new FlashcardFactory();
        ImportDeckInputBoundary interactor = new ImportDeckInteractor(deckRepository, presenter, cardFactory);
        ImportDeckInputData inputData = new ImportDeckInputData("Test");
        interactor.importDeck(inputData);
    }

    @Test
    void importInvalidFile(){
        Map<String, List<String>> files = new HashMap<>();
        List<String> fileContents = new ArrayList<>();
        fileContents.add("QANDA-Will this pass?-No");
        files.put("BadTest", fileContents);
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Deck actual = Deck.getTracker().get(outputData.getImportedDeckName());
                Assertions.assertEquals("BadTest", actual.getName());
                List<Flashcard> actualCards = actual.getCards();
                Assertions.assertTrue(actualCards.isEmpty());
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.fail(exception);
            }
        };
        CardFactory cardFactory = new FlashcardFactory();
        ImportDeckInputBoundary interactor = new ImportDeckInteractor(deckRepository, presenter, cardFactory);
        ImportDeckInputData inputData = new ImportDeckInputData("BadTest");
        interactor.importDeck(inputData);
    }
}