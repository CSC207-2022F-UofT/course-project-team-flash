package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck("Testing Deck");
    }

    @Test
    void getName() {
        String actual = "Testing Deck";
        String expected = deck.getName();
        assert actual.equals(expected);
    }

    @Test
    void setName() {
        String actual = "New Deck Name";
        deck.setName("New Deck Name");
        String expected = deck.getName();
        assert actual.equals(expected);
    }

    @Test
    void getZeroCards() {
        List<Flashcard> expected = deck.getCards();
        assert expected.equals(new ArrayList<>());
    }

    @Test
    void getCards() {
        Flashcard card1 = new QandAFlashcard("Question", "Answer");
        Flashcard card2 = new QandAFlashcard("Question", "Answer");
        Flashcard card3 = new QandAFlashcard("Question", "Answer");
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        List<Flashcard> actual = new ArrayList<>(
                Arrays.asList(card1, card2, card3)
        );
        List<Flashcard> expected = deck.getCards();
        assert actual.equals(expected);
    }

    @Test
    void addCard() {
        Flashcard card1 = new QandAFlashcard("Question", "Answer");
        deck.addCard(card1);
        List<Flashcard> actual = new ArrayList<>();
        actual.add(card1);
        List<Flashcard> expected = deck.getCards();
        assert actual.equals(expected);
    }

    @AfterEach
    void tearDown() {
    }
}