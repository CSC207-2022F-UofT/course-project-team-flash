package entities;

import java.util.List;

public interface CardFactory {
    Flashcard createCard(int type, String question, String answer, List<String> options);
}
