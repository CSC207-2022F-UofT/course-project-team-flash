/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */

package createQuiz;

/**
 * This file contains the implementation of the CreateQuizOutputData class.
 * It includes the instance attributes of the CreateQuizOutputData class and
 * their getter methods.
 */
public class CreateQuizOutputData {

    private final String quizName;
    private final String message;

    /**
     * Creates a new CreateQuizOutputData given the quiz name and a message.
     *
     * @param quizName the name of the quiz that is created
     * @param message a message indicating whether this quiz is created and stored successfully.
     */
    public CreateQuizOutputData(String quizName, String message) {
        this.quizName = quizName;
        this.message = message;
    }

    /**
     * Returns the quizName of this CreateQuizOutputData.
     *
     * @return the quizName of this CreateQuizOutputData
     */
    public String getQuizName() {
        return this.quizName;
    }

    /**
     * Returns the message of this CreateQuizOutputData.
     *
     * @return the message of this CreateQuizOutputData
     */
    public String getMessage() {
        return this.message;
    }
}