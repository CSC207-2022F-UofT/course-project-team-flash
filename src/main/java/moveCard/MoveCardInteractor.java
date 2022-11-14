package moveCard;

import entities.Flashcard;

import entities.Deck;
public class MoveCardInteractor implements MoveCardInputBoundary{

    private MoveCardOutputBoundary moveCardOutputBoundary;

    public MoveCardInteractor(MoveCardOutputBoundary moveCardOutputBoundary) {
        this.moveCardOutputBoundary = moveCardOutputBoundary;
    }

    @Override
    public void move(MoveCardInputData moveCardInputData) {
        Flashcard card = Flashcard.getTracker().get(moveCardInputData.getCardID());
        Deck oldDeck = Deck.getTracker().get(moveCardInputData.getOldDeckID());
        Deck newDeck = Deck.getTracker().get(moveCardInputData.getNewDeckID());

        oldDeck.removeCard(card);
        newDeck.addCard(card);

        MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Flashcard moved.");
        moveCardOutputBoundary.prepareSuccessView(moveCardOutputData);
    }
}
