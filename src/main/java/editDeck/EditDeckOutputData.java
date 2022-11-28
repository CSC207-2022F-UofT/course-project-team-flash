package editDeck;

import entities.Deck;

public class EditDeckOutputData {

    private Deck deck;
    private String message;
    public EditDeckOutputData(Deck deck, String message) {
        this.deck = deck;
        this.message = message;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getMessage() {
        return message;
    }
}
