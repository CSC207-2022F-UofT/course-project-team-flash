package entities;

import java.util.List;

public interface CardFactory {
    Flashcard getCard(int type, String question, String answer, List<String> options);
}
