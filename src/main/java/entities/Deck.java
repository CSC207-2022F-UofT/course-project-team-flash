package entities;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private String name;
    private List<Flashcard> cards;

    /**
     * Constructor for the Deck object
     * @param name a String representing the name of this deck
     */
    public Deck(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Flashcard> getCards() {
        return cards;
    }
    public void addCard(Flashcard card) {
        this.cards.add(card);
    }
}
