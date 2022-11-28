package editDeck;

import entities.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EditDeckInteractorTest {
    @BeforeEach
    void createDeck(){
        Deck deckToDelete = new Deck("Test");
        Deck.addTracker(deckToDelete.getName(), deckToDelete);
    }
    @Test
    void editDeck(){

    }
}
