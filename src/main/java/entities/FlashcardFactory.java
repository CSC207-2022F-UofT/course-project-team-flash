package entities;

import java.util.List;

public class FlashcardFactory {
    public Flashcard getCard(int type, String question, String answer, List<String> options) {
        if (type == 1) {
            return new QandAFlashcard(question, answer);
        } else if (type == 2) {
            return new MCFlashcard(question, answer, options);
        } else if (type == 3) {
            return new SelectAllFlashcard(question, answer, options);
        }
        return null;
    }
}
