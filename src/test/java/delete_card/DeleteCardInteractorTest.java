package delete_card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entities.*;


class DeleteCardInteractorTest {

    @Test
    void deleteCard() {
        Deck deck = new Deck("Test");
        Deck.addTracker(deck.getName(), deck);
        Flashcard card = new QandAFlashcard("TestQuestion", "TestAnswer");
        String cardID = card.getUniqueID();
        Flashcard.addTracker(cardID, card);

        deck.addCard(card);
        DeleteCardOutputBoundary presenter = new DeleteCardPresenter(null){
            @Override
            public void prepareSuccessView(DeleteCardOutputData deleteCardOutputData) {
                Assertions.assertNull(Flashcard.getTracker().get(cardID));
                Assertions.assertFalse(deck.getCards().contains(card));
            }

            @Override
            public void prepareFailView(DeleteCardOutputData deleteCardOutputData) {
                Assertions.fail("Unexpected failure.");
            }
        };

        DeleteCardInputBoundary interactor = new DeleteCardInteractor(presenter);
        DeleteCardInputData inputData = new DeleteCardInputData(cardID, deck.getName());
        interactor.delete(inputData);
    }

    @Test
    void deleteNonExistingCard() {

        DeleteCardOutputBoundary presenter = new DeleteCardPresenter(null){
            @Override
            public void prepareSuccessView(DeleteCardOutputData deleteCardOutputData) {
                Assertions.fail("Should not delete card that does not exist");
            }

            @Override
            public void prepareFailView(DeleteCardOutputData deleteCardOutputData) {
                Assertions.assertEquals("Card not found", deleteCardOutputData.getMessage());
            }
        };

        DeleteCardInputBoundary interactor = new DeleteCardInteractor(presenter);
        DeleteCardInputData inputData = new DeleteCardInputData("69420", "Test");
        interactor.delete(inputData);
    }
}