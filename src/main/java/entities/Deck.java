package entities;
import java.util.List;

public class Deck {

    private String name;
    private List<Flashcard> cards;

    /**
     * Constructor for the Deck object
     * @param name a String representing the name of this deck
     * @param cards a List that stores all the flashcards in this deck
     */
    public Deck(String name, List<Flashcard> cards) {
        this.name = name;
        this.cards = cards;
    }
}
