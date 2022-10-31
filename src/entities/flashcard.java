/*
 * Author: Andrew Nguyen
 * Date: October 31/22
 * This abstract class contains the blueprint for a flashcard entity
 */

public abstract class flashcard {

    private String question;
    private String answer;

    /**
     * Constructor for the flashcard object
     * @param question a String representing the question
     * @param answer a String representing the correct answer
     */
    public flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
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
}