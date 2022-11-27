/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * The output data object for the presenter.
 */
package editQuiz;

public class EditQuizOutputData {
    private final String quizName;

    /**
     * A data object constructor for the interactor to use
     *
     * @param quizName the new name of the quiz
     */
    public EditQuizOutputData(String quizName) {
        this.quizName = quizName;
    }

    /**
     * A getter method
     *
     * @return a string representing the new name of the quiz
     */
    public String getQuizName() {
        return quizName;
    }
}
