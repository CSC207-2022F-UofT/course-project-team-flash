/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * The output data object for the presenter.
 */
package edit_quiz;

public class EditQuizOutputData {
    private final String message;
    private final String oldName;
    /**
     * A data object constructor for the interactor to use
     *
     * @param message an error message
     */
    public EditQuizOutputData(String message) {
        this.message = message;
        this.oldName = null;
    }

    /**
     * A data object constructor for the interactor to use
     *
     * @param message the new name of the deck
     * @param oldName the old name of the deck
     */
    public EditQuizOutputData(String message, String oldName) {
        this.message = message;
        this.oldName = oldName;
    }
    /**
     * A getter method
     *
     * @return a string with the message
     */
    public String getMessage() {
        return message;
    }

    public String getOldName() {
        return oldName;
    }
}
