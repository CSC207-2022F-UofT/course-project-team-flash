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
        files.put("home\\ImportTest1.deck", fileContents);
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Deck actual = Deck.getTracker().get(outputData.getImportedDeckName());
                Assertions.assertEquals("ImportTest1", actual.getName());
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
        ImportDeckInputData inputData = new ImportDeckInputData("home\\ImportTest1.deck");
        interactor.importDeck(inputData);
    }

    @Test
    void importInvalidFile(){
        Map<String, List<String>> files = new HashMap<>();
        List<String> fileContents = new ArrayList<>();
        fileContents.add("QANDA-Will this pass?-No");
        files.put("home/ImportTest2", fileContents);
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Deck actual = Deck.getTracker().get(outputData.getImportedDeckName());
                Assertions.assertEquals("ImportTest2", actual.getName());
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
        ImportDeckInputData inputData = new ImportDeckInputData("home/ImportTest2");
        interactor.importDeck(inputData);
    }

    @Test
    void importNonExistingFile(){
        Map<String, List<String>> files = new HashMap<>();
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Assertions.fail("Should not be able to import nothing!");
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.assertEquals("ImportTest3 doesn't exist", exception);
            }
        };
        CardFactory cardFactory = new FlashcardFactory();
        ImportDeckInputBoundary interactor = new ImportDeckInteractor(deckRepository, presenter, cardFactory);
        ImportDeckInputData inputData = new ImportDeckInputData("home\\ImportTest3.deck");
        interactor.importDeck(inputData);
    }

    @Test
    void importExistingDeck() {
        Deck theDeck = new Deck("ImportTest4");
        Deck.addTracker(theDeck.getName(), theDeck);
        Map<String, List<String>> files = new HashMap<>();
        List<String> fileContents = new ArrayList<>();
        files.put("home/ImportTest4.deck", fileContents);
        ImportDeckDsGateway deckRepository = new DeckInMemoryImport(files);
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(null) {
            @Override
            public void prepareSuccessView(ImportDeckOutputData outputData){
                Assertions.fail("Should not be able to import a duplicate!");
            }

            @Override
            public void prepareFailView(String exception){
                Assertions.assertEquals("Could not import! ImportTest4 already exists!", exception);
            }
        };
        CardFactory cardFactory = new FlashcardFactory();
        ImportDeckInputBoundary interactor = new ImportDeckInteractor(deckRepository, presenter, cardFactory);
        ImportDeckInputData inputData = new ImportDeckInputData("home/ImportTest4.deck");
        interactor.importDeck(inputData);
    }
}