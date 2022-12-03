package createCard;

import entities.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class CreateCardInteractorTest {

    @BeforeAll
    public static void setup() {
        Deck testingDeck = new Deck("Testing Deck");
        Deck.addTracker("Testing Deck", testingDeck);

    }

    @Test
    void createOneQandACard() {
        CreateCardOutputBoundary presenter = new CreateCardPresenter(null) {
            @Override
            public void prepareSuccessView(CreateCardOutputData outputData) {
                Assertions.assertEquals(Flashcard.getTracker().size(), 1);
                for (String key : Flashcard.getTracker().keySet()) {
                    Flashcard card = Flashcard.getTracker().get(key);
                    Assertions.assertEquals(card.getQuestion(), "question");
                    Assertions.assertEquals(card.getAnswer(), "answer");
                    Assertions.assertTrue(card instanceof QandAFlashcard);
                }

            }

            @Override
            public void prepareFailView(CreateCardOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        CardFactory factory = new FlashcardFactory();
        CreateCardInputBoundary interactor = new CreateCardInteractor(presenter, factory);
        CreateCardInputData inputData = new CreateCardInputData("Testing Deck",  "question", "answer");
        interactor.create(inputData);
    }

    @Test
    void createOneMCCard() {
        CreateCardOutputBoundary presenter = new CreateCardPresenter(null) {
            @Override
            public void prepareSuccessView(CreateCardOutputData outputData) {
                Assertions.assertEquals(outputData.getQuestion(), "question");
                Assertions.assertEquals(outputData.getAnswer(), "answer");
                Assertions.assertEquals(outputData.getType(), "Multiple Choice");
            }

            @Override
            public void prepareFailView(CreateCardOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        CardFactory factory = new FlashcardFactory();
        CreateCardInputBoundary interactor = new CreateCardInteractor(presenter, factory);

        List<String> options = new ArrayList<>();
        options.add("option1");
        options.add("option2");
        options.add("option3");

        CreateCardInputData inputData = new CreateCardInputData(
                "Testing Deck", "question", "answer", options);
        interactor.create(inputData);
    }

    @Test
    void noName() {
        CreateCardOutputBoundary presenter = new CreateCardPresenter(null) {
            @Override
            public void prepareSuccessView(CreateCardOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }

            @Override
            public void prepareFailView(CreateCardOutputData outputData) {
                Assertions.assertEquals(outputData.getMessage(), "Flashcard Creation Failed. No Question Stated.");
            }
        };

        CardFactory factory = new FlashcardFactory();
        CreateCardInputBoundary interactor = new CreateCardInteractor(presenter, factory);
        CreateCardInputData inputData = new CreateCardInputData("Testing Deck",  "", "answer");
        interactor.create(inputData);
    }

    @AfterEach
    public void tearDown() {
        Flashcard.getTracker().clear();
    }

    @AfterAll
    public static void delete() {
        Deck.getTracker().clear();
    }
}