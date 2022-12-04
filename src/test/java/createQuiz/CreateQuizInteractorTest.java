/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 28/22
 *
 * This file contains tests for the Create Quiz use case.
 */


package createQuiz;
import entities.Deck;
import entities.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateQuizInteractorTest {

    @Test
    public void createOneQuiz() {


        // Create 3 decks
        Deck deckA = new Deck("deckA");
        Deck.addTracker("deckA", deckA);
        Deck deckB = new Deck("deckB");
        Deck.addTracker("deckB", deckB);
        Deck deckC = new Deck("deckC");
        Deck.addTracker("deckC", deckC);


        // decksList is a list of the 3 deck objects
        List<Deck> decksList = new ArrayList<>();
        decksList.add(deckA);
        decksList.add(deckB);
        decksList.add(deckC);

        // decksNameList is a list of the name of the 3 deck objects
        List<String> decksNameList = new ArrayList<>();
        decksNameList.add("deckA");
        decksNameList.add("deckB");
        decksNameList.add("deckC");

        // Setup finished

        CreateQuizOutputBoundary presenter = new CreateQuizPresenter(null) {
            @Override
            public void prepareSuccessView(CreateQuizOutputData outputData) {
                Assertions.assertEquals("Test", Quiz.getTracker().get("Test").getQuizName());
                System.out.println(Quiz.getTracker().get("Test").getDecks());
                Assertions.assertEquals(decksList, Quiz.getTracker().get("Test").getDecks());

            }

            @Override
            public void prepareFailView(CreateQuizOutputData outputData) {
                System.out.println("Unexpected failure");
            }

        };

        CreateQuizInputBoundary interactor = new CreateQuizInteractor(presenter);
        CreateQuizInputData inputData = new CreateQuizInputData("Test", decksNameList);
        interactor.createQuiz(inputData);

    }

    @Test
    public void createQuizNoDecks() {
        CreateQuizOutputBoundary presenter = new CreateQuizPresenter(null) {
            @Override
            public void prepareSuccessView(CreateQuizOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }

            @Override
            public void prepareFailView(CreateQuizOutputData outputData) {
                Assertions.assertEquals("This quiz does not contain any deck. Failed to create new quiz.",
                        outputData.getMessage());
            }

        };

        CreateQuizInputBoundary interactor = new CreateQuizInteractor(presenter);
        List<String> decksList = new ArrayList<>();
        CreateQuizInputData inputData = new CreateQuizInputData("Test", decksList);
        interactor.createQuiz(inputData);
    }

    @Test
    public void createQuizDuplicate() {

        // Create 3 decks
        Deck deckA = new Deck("deckA");
        Deck.addTracker("deckA", deckA);
        Deck deckB = new Deck("deckB");
        Deck.addTracker("deckB", deckB);
        Deck deckC = new Deck("deckC");
        Deck.addTracker("deckC", deckC);


        // decksList is a list of the 3 deck objects
        List<Deck> decksList = new ArrayList<>();
        decksList.add(deckA);
        decksList.add(deckB);
        decksList.add(deckC);

        // decksNameList is a list of the name of the 3 deck objects
        List<String> decksNameList = new ArrayList<>();
        decksNameList.add("deckA");
        decksNameList.add("deckB");
        decksNameList.add("deckC");

        // Setup finished

        CreateQuizOutputBoundary presenter = new CreateQuizPresenter(null) {
            @Override
            public void prepareSuccessView(CreateQuizOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }

            @Override
            public void prepareFailView(CreateQuizOutputData outputData) {
                Assertions.assertEquals("This quiz name exists already. Failed to create new quiz.",
                        outputData.getMessage());
            }

        };

        // Create a new quiz called "sample"
        Quiz sample = new Quiz("sample", decksList);
        Quiz.addTracker("sample", sample);

        CreateQuizInputBoundary interactor = new CreateQuizInteractor(presenter);
        CreateQuizInputData inputData = new CreateQuizInputData("sample", decksNameList);
        interactor.createQuiz(inputData);
    }


}