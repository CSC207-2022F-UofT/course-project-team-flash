package moveCard;

import entities.Deck;
import entities.Flashcard;

public class MoveCardInputData {

    private String oldDeckID;

    private String newDeckID;
    private String cardID;

    public MoveCardInputData(String card, String oldDeck, String newDeck) {
        this.cardID = card;
        this.oldDeckID = oldDeck;
        this.newDeckID = newDeck;
    }

    public String getOldDeckID() {
        return this.oldDeckID;
    }

    public String getNewDeckID() { return this.newDeckID; };

    public String getCardID() {
        return this.cardID;
    }
}
