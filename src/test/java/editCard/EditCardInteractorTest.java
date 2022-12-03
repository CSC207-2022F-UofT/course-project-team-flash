package editCard;
import entities.Deck;
import entities.Flashcard;
import entities.MCFlashcard;
import entities.QandAFlashcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EditCardInteractorTest {

    @Test
    public void editQandACard() {
        Deck testDeck = new Deck("Test Deck");
        Deck.addTracker("Test Deck", testDeck);

        Flashcard card = new QandAFlashcard("testQuestion", "testAnswer");
        Flashcard.addTracker(card.getUniqueID(), card);
        testDeck.addCard(card);

        EditCardOutputBoundary presenter = new EditCardPresenter(null){
            @Override
            public void prepareSuccessView(EditCardOutputData outputData) {
                Assertions.assertEquals("newQuestion", card.getQuestion());
                Assertions.assertEquals("newAnswer", card.getAnswer());
            }
            @Override
            public void prepareFailView(EditCardOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        //Setup Input Data
        String newQuestion = "newQuestion";
        String newAnswer = "newAnswer";

        //Create interactor and run the use case:
        EditCardInputBoundary interactor = new EditCardInteractor(presenter);
        EditCardInputData inputData = new EditCardInputData(card.getUniqueID(),
                newQuestion, newAnswer);
        interactor.edit(inputData);
    }

    @Test
    public void editMCCard() {
        Deck testDeck = new Deck("Test Deck");
        Deck.addTracker("Test Deck", testDeck);

        List<String> options = new ArrayList<>();
        options.add("option1");
        options.add("option2");
        options.add("option3");

        MCFlashcard mcCard = new MCFlashcard("testQuestion", "testAnswer", options);
        Flashcard.addTracker(mcCard.getUniqueID(), mcCard);
        testDeck.addCard(mcCard);

        EditCardOutputBoundary presenter = new EditCardPresenter(null){
            @Override
            public void prepareSuccessView(EditCardOutputData outputData) {
                Assertions.assertEquals("newQuestion", mcCard.getQuestion());
                Assertions.assertEquals("newAnswer", mcCard.getAnswer());
                Assertions.assertTrue(mcCard.getOptions().contains("newOption1"));
                Assertions.assertTrue(mcCard.getOptions().contains("newOption2"));
                Assertions.assertTrue(mcCard.getOptions().contains("newOption3"));
            }

            @Override
            public void prepareFailView(EditCardOutputData outputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        //Setup Input Data
        String newQuestion = "newQuestion";
        String newAnswer = "newAnswer";
        List<String> newOptions = new ArrayList<>();
        newOptions.add("newOption1");
        newOptions.add("newOption2");
        newOptions.add("newOption3");


        //Create interactor and run the use case:
        EditCardInputBoundary interactor = new EditCardInteractor(presenter);
        EditCardInputData inputData = new EditCardInputData(mcCard.getUniqueID(),
                newQuestion, newAnswer, newOptions);
        interactor.edit(inputData);
    }
}
