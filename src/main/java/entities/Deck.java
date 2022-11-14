package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Deck {

    private String name;
    private List<Flashcard> cards;

    private final String uniqueID;

    /**
     * Constructor for the Deck object
     * @param name a String representing the name of this deck
     */
    public Deck(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.uniqueID = UUID.randomUUID().toString();
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
    public String getUniqueID() {
        return uniqueID;
    }
}
