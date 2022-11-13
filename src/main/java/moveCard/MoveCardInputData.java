package moveCard;

import entities.Deck;
import entities.Flashcard;

public class MoveCardInputData {

    private Deck deck;
    private Flashcard card;

    public MoveCardInputData(Flashcard card, Deck deck) {
        this.card = card;
        this.deck = deck;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Flashcard getCard() {
        return this.card;
    }
}
