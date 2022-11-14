package entities;/*
 * Author: Andrew Nguyen
 * Date: October 31/22
 * This abstract class contains the blueprint for a flashcard entity
 */

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Flashcard {

    private String question;
    private String answer;
    private final String uniqueID;
    private static final Map<String, Flashcard> flashcardTracker = new HashMap<>();

    /**
     * Constructor for the flashcard object
     * @param question a String representing the question
     * @param answer a String representing the correct answer
     */
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.uniqueID = UUID.randomUUID().toString();
    }

    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    public void setAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUniqueID() {
        return uniqueID;
    }
    public static Map<String, Flashcard> getTracker() {
        return flashcardTracker;
    }
    public static void addTracker(String uniqueID, Flashcard card) {
        flashcardTracker.put(uniqueID, card);
    }
    public static void removeTracker(String uniqueID) {
        flashcardTracker.remove(uniqueID);
    }

}