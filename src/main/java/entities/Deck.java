package entities;
import java.util.*;

public class Deck {

    private String name;
    private final List<Flashcard> cards;
    private static final Map<String, Deck> deckTracker = new HashMap<>();

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
    public static Map<String, Deck> getTracker() {
        return deckTracker;
    }
    public static void addTracker(String deckName, Deck deck) {
        deckTracker.put(deckName, deck);
    }
    public static void removeTracker(String deckName) {
        deckTracker.remove(deckName);
    }
}
