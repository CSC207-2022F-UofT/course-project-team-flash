package entities;

import java.util.List;

public interface CardFactory {
    Flashcard createCard(FlashcardType type, String question, String answer, List<String> options);
}
