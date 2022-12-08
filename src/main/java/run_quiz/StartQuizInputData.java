/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 * This file contains implementation of the StartQuizInputData class.
 * It includes the instance attributes of StartQuizInputData and
 * the getter methods for them.
 */

package run_quiz;

public class StartQuizInputData {
    private final String quizId;
    private final boolean isRandomized;

    /**
     * Creates a new StartQuizInputData with the given quiz ID (name) and a
     * boolean value indicating whether the questions in this quiz appear in
     * a randomized order.
     *
     * @param quizId the ID (name) of this quiz
     * @param isRandomized whether the questions in this quiz appear in a
     *                     randomized order
     */
    public StartQuizInputData(String quizId, Boolean isRandomized) {
        this.quizId = quizId;
        this.isRandomized = isRandomized;
    }

    /**
     * Returns the quizId of this StartQuizInputData.
     *
     * @return the quizId of this StartQuizInputData
     */
    public String getQuizId(){
        return this.quizId;
    }

    /**
     * Returns the isRandomized of this StartQuizInputData.
     *
     * @return the isRandomized of this StartQuizInputData
     */
    public boolean getIsRandomized(){
        return this.isRandomized;
    }
}

