package entities;/*
 * Author: Andrew Nguyen
 * Date: October 31/22
 * This abstract class contains the blueprint for a flashcard entity
 */

import java.util.ArrayList;
import java.util.List;

public class SelectAllFlashcard extends Flashcard {

    private String question;
    private String answer;
    private List<String> options;

    /**
     *
     * @param question a String representing the question
     * @param answer a String representing the correct answer
     * @param options a String representing the first incorrect option
     */
    public SelectAllFlashcard(String question, String answer, List<String> options) {
        super(question, answer);
        this.options = options;
    }

    public void setOptions(int index, String newQuestion) {
        options.set(index, newQuestion);
    }

    public List<String> getOptions() {
        return options;
    }
}
