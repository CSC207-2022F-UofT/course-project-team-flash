package moveCard;

import entities.Deck;
import entities.Flashcard;

public class MoveCardOutputData {

    private Deck deck;
    private Flashcard card;

    public MoveCardOutputData(Deck deck, Flashcard card) {
        this.deck = deck;
        this.card = card;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Flashcard getCard() {
        return this.card;
    }
}
