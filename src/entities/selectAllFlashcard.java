/*
 * Author: Andrew Nguyen
 * Date: October 31/22
 * This abstract class contains the blueprint for a flashcard entity
 */

import java.util.ArrayList;

public class selectAllFlashcard extends flashcard{

    private String question;
    private String answer;
    private ArrayList<String> options;

    /**
     *
     * @param question a String representing the question
     * @param answer a String representing the correct answer
     * @param options a String representing the first incorrect option
     */
    public selectAllFlashcard(String question, String answer, ArrayList<String> options) {
        super(question, answer);
        this.options = options;
    }

    public void setOptions(int index, String newQuestion) {
        options.set(index, newQuestion);
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}
