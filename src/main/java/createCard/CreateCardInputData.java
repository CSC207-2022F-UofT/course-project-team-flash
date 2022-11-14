package createCard;

import entities.Deck;

import java.util.List;

public class CreateCardInputData {
    private final Deck deck;
    private final String question;
    private final String answer;
    private final int type;
    private final List<String> options;

    public CreateCardInputData(Deck deck, int type, String question, String answer, List<String> options) {
        this.deck = deck;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
    public CreateCardInputData(Deck deck, int type, String question, String answer) {
        this.deck = deck;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.options = null;
    }

    public Deck getDeck() {
        return deck;
    }
    public int getType() {
        return type;
    }
    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

}
