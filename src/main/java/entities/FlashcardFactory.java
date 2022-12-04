package entities;

import java.util.List;

public class FlashcardFactory implements CardFactory {
    public Flashcard createCard(FlashcardType type, String question, String answer, List<String> options) {
        if (type == FlashcardType.QandAFlashcard) {
            return new QandAFlashcard(question, answer);
        } else if (type == FlashcardType.MCFlashcard) {
            return new MCFlashcard(question, answer, options);
        }
        return null;
    }
}
