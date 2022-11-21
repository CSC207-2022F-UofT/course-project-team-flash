package createQuiz;

import entities.Quiz;

/**
 * This file contains the implementation of the CreateQuizOutputData class.
 * It includes the instance attributes of the CreateQuizOutputData class and
 * their getter methods.
 */

public class CreateQuizOutputData {

    private final Quiz quiz;
    private final String message;

    /**
     * Creates a new CreateQuizOutputData given the quiz object and a message.
     *
     * @param quiz the quiz object that is created
     * @param message a message indicating whether this quiz is created and stored successfully.
     */
    public CreateQuizOutputData(Quiz quiz, String message) {
        this.quiz = quiz;
        this.message = message;
    }

    /**
     * Returns the quiz object of this CreateQuizOutputData.
     *
     * @return
     */
    public Quiz getQuiz() {
        return this.quiz;
    }

    /**
     * Returns the message of this CreateQuizOutputData.
     *
     * @return
     */
    public String getMessage() {
        return this.message;
    }
}
