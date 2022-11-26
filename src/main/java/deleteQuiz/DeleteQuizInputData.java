/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 *
 * This file contains implementation of the DeleteQuizInputData class.
 * It includes the instance attributes of DeleteQuizInputData and the getter methods for them.
 */

package deleteQuiz;

public class DeleteQuizInputData {

    private final String quizName;

    /**
     * Creates a new DeleteQuizInputData with the given quiz name.
     *
     * @param quizName the name of the quiz
     */
    public DeleteQuizInputData(String quizName) {
        this.quizName = quizName;
    }

    /**
     * Returns the quiz name of this DeleteQuizInputData.
     *
     * @return the quiz name of this DeleteQuizInputData
     */
    public String getQuizName() {
        return this.quizName;
    }

}