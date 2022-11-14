package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MCFlashcardTest {

    @Test
    void setQuestion() {
        String question = "What is 9 + 10?";
        String answer = "19";
        List<String> options = Arrays.asList("18", "20", "21");
        Flashcard card = new MCFlashcard(question, answer, options);

        card.setQuestion("What is 8 + 11?");
        assert card.getQuestion().equals("What is 8 + 11?");
    }

    @Test
    void setAnswer() {
        String question = "What is 9 + 10?";
        String answer = "10";
        List<String> options = Arrays.asList("18", "20", "21");
        Flashcard card = new MCFlashcard(question, answer, options);

        card.setAnswer("19");
        assert card.getAnswer().equals("19");
    }

    @Test
    void getQuestion() {
        String question = "What is 9 + 10?";
        String answer = "19";
        List<String> options = Arrays.asList("18", "20", "21");
        Flashcard card = new MCFlashcard(question, answer, options);

        assert card.getQuestion().equals("What is 9 + 10?");
    }

    @Test
    void getAnswer() {
        String question = "What is 9 + 10?";
        String answer = "19";
        List<String> options = Arrays.asList("18", "20", "21");
        Flashcard card = new MCFlashcard(question, answer, options);

        assert card.getAnswer().equals("19");
    }

    @Test
    void getOptions() {
        String question = "What is 9 + 10?";
        String answer = "19";
        List<String> options = Arrays.asList("18", "20", "21");
        MCFlashcard card = new MCFlashcard(question, answer, options);

        assert card.getOptions().equals(Arrays.asList("18", "20", "21"));
    }

    @Test
    void setOptions() {
        String question = "What is 9 + 10?";
        String answer = "19";
        List<String> options = Arrays.asList("18", "20", "21");
        MCFlashcard card = new MCFlashcard(question, answer, options);

        card.setOptions(Arrays.asList("18", "20", "22"));
        assert card.getOptions().equals(Arrays.asList("18", "20", "22"));
    }
}