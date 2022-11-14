package entities;
import java.util.*;

public class Deck {

    private String name;
    private final List<Flashcard> cards;
    private final String uniqueID;
    private static final Map<String, Deck> deckTracker = new HashMap<>();

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
    public static Map<String, Deck> getTracker() {
        return deckTracker;
    }
    public static void addTracker(String uniqueID, Deck deck) {
        deckTracker.put(uniqueID, deck);
    }
    public static void removeTracker(String uniqueID) {
        deckTracker.remove(uniqueID);
    }
}
