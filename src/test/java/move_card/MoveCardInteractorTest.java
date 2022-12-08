package move_card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.*;

class MoveCardInteractorTest {

    @Test
    void moveToNewDeck() {
        Deck oldDeck = new Deck("oldDeck");
        Deck.addTracker(oldDeck.getName(), oldDeck);
        Deck newDeck = new Deck("newDeck");
        Deck.addTracker(newDeck.getName(), newDeck);

        Flashcard card = new QandAFlashcard("testQuestion", "testAnswer");
        Flashcard.addTracker(card.getUniqueID(), card);
        oldDeck.addCard(card);

        MoveCardOutputBoundary presenter = new MoveCardPresenter(null){
            @Override
            public void prepareSuccessView(MoveCardOutputData moveCardOutputData) {
                Assertions.assertTrue(newDeck.getCards().contains(card));
            }
            @Override
            public void prepareFailView(MoveCardOutputData movecardOutputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        MoveCardInputBoundary interactor = new MoveCardInteractor(presenter);
        MoveCardInputData inputData = new MoveCardInputData(card.getUniqueID(), oldDeck.getName(), newDeck.getName());
        interactor.move(inputData);

    }

    @Test
    void moveCardNotInDeck() {
        Deck oldDeck = new Deck("oldDeck");
        Deck.addTracker(oldDeck.getName(), oldDeck);
        Deck newDeck = new Deck("newDeck");
        Deck.addTracker(newDeck.getName(), newDeck);

        Flashcard card = new QandAFlashcard("testQuestion", "testAnswer");
        Flashcard.addTracker(card.getUniqueID(), card);

        MoveCardOutputBoundary presenter = new MoveCardPresenter(null){
            @Override
            public void prepareSuccessView(MoveCardOutputData moveCardOutputData) {
                Assertions.fail("Should not move card if not in deck");
            }
            @Override
            public void prepareFailView(MoveCardOutputData moveCardOutputData) {
                Assertions.assertEquals("Card not found", moveCardOutputData.getMessage());
            }
        };

        MoveCardInputBoundary interactor = new MoveCardInteractor(presenter);
        MoveCardInputData inputData = new MoveCardInputData(card.getUniqueID(), oldDeck.getName(), newDeck.getName());
        interactor.move(inputData);
    }

    @Test
    void moveCardNoDeck() {
        Deck oldDeck = new Deck("oldDeck");
        Deck.addTracker(oldDeck.getName(), oldDeck);

        Flashcard card = new QandAFlashcard("testQuestion", "testAnswer");
        Flashcard.addTracker(card.getUniqueID(), card);
        oldDeck.addCard(card);

        MoveCardOutputBoundary presenter = new MoveCardPresenter(null){
            @Override
            public void prepareSuccessView(MoveCardOutputData moveCardOutputData) {
                Assertions.fail("Should not move card to non-existing deck");
            }
            @Override
            public void prepareFailView(MoveCardOutputData moveCardOutputData) {
                Assertions.assertEquals("Deck not found", moveCardOutputData.getMessage());
            }
        };

        MoveCardInputBoundary interactor = new MoveCardInteractor(presenter);
        MoveCardInputData inputData = new MoveCardInputData(card.getUniqueID(), oldDeck.getName(), "nonExistingDeck");
        interactor.move(inputData);
    }
}