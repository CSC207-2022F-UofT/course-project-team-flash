/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * The output data object for the presenter.
 */
package editQuiz;

public class EditQuizOutputData {
    private final String message;

    /**
     * A data object constructor for the interactor to use
     *
     * @param message the new name of the quiz
     */
    public EditQuizOutputData(String message) {
        this.message = message;
    }

    /**
     * A getter method
     *
     * @return a string with the message
     */
    public String getMessage() {
        return message;
    }
}
