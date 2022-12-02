package entities;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class QandAFlashcardTest {



    @Test
    void setQuestion() {
        String question = "What is 9 + 10?";
        String answer = "19";
        Flashcard card = new QandAFlashcard(question, answer);

        card.setQuestion("What is 8 + 11?");
        assert card.getQuestion().equals("What is 8 + 11?");
    }

    @Test
    void setAnswer() {
        String question = "What is 9 + 10?";
        String answer = "10";
        Flashcard card = new QandAFlashcard(question, answer);

        card.setAnswer("19");
        assert card.getAnswer().equals("19");
    }

    @Test
    void getQuestion() {
        String question = "What is 9 + 10?";
        String answer = "19";
        Flashcard card = new QandAFlashcard(question, answer);

        assert card.getQuestion().equals("What is 9 + 10?");
    }

    @Test
    void getAnswer() {
        String question = "What is 9 + 10?";
        String answer = "19";
        Flashcard card = new QandAFlashcard(question, answer);

        assert card.getAnswer().equals("19");
    }

    @Test
    void getUniqueID() {
        String question = "What is 9 + 10?";
        String answer = "19";
        Flashcard card = new QandAFlashcard(question, answer);
        Flashcard.addTracker(card.getUniqueID(), card);

        assert card.getUniqueID() != null;
    }

    @After
    public void tearDown(){
        Map<String, Flashcard> tracker = Flashcard.getTracker();
        for (String key: tracker.keySet()) {
            tracker.remove(key);
        }
    }

    @Test
    void addTracker() {
        String question = "What is 9 + 10?";
        String answer = "19";

        Flashcard card1 = new QandAFlashcard(question, answer);
        Flashcard.addTracker(card1.getUniqueID(), card1);
        Flashcard card2 = new QandAFlashcard(question, answer);
        Flashcard.addTracker(card2.getUniqueID(), card2);

        assert Flashcard.getTracker().size() == 5;
    }


}