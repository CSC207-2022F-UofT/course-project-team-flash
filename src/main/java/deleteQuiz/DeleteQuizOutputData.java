/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 */

package deleteQuiz;

/**
 * This file contains the implementation of the DeleteQuizOutputData class.
 * It includes the instance attributes of the DeleteQuizOutputData class and
 * their getter methods.
 */
public class DeleteQuizOutputData {

    private final String quizName;
    private final String message;

    /**
     * Creates a new DeleteQuizOutputData given the quiz name and a message.
     *
     * @param quizName the name of the quiz to be deleted
     * @param message a message indicating whether this quiz is deleted successfully.
     */
    public DeleteQuizOutputData(String quizName, String message) {
        this.quizName = quizName;
        this.message = message;
    }

    /**
     * Returns the quizName of this DeleteQuizOutputData.
     *
     * @return the quizName of this DeleteQuizOutputData
     */
    public String getQuizName() {
        return this.quizName;
    }

    /**
     * Returns the message of this DeleteQuizOutputData.
     *
     * @return the message of this DeleteQuizOutputData
     */
    public String getMessage() {
        return this.message;
    }
}