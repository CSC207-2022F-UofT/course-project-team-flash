
/*
 * Author: Andrew Nguyen
 */

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

    public List<String> getCardIds(){

        List<String> cardIds = new ArrayList<String>();

        for(Flashcard card : this.cards){
            cardIds.add(card.getUniqueID());
        }

        return cardIds;
    }
    public void addCard(Flashcard card) {
        this.cards.add(card);
    }
    public void removeCard(Flashcard card) {
        this.cards.remove(card);
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

    public static boolean containsDeckName(String deckName){
        return deckTracker.containsKey(deckName);
    }
}

