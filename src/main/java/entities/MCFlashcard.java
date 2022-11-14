package entities;

import java.util.List;

public class MCFlashcard extends Flashcard {

    private List<String> options;

    /**
     * Constructor for the flashcard object
     *
     * @param question a String representing the question
     * @param answer   a String representing the correct answer
     */
    public MCFlashcard(String question, String answer, List<String> options) {
        super(question, answer);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
