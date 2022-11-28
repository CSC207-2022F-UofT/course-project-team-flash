/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * The input data object for the interactor.
 */
package editQuiz;

public class EditQuizInputData {
    private final String oldName;
    private final String newName;

    /**
     * A data object constructor for the interactor to use
     *
     * @param oldName the name of the quiz to be changed
     * @param newName the new name of the quiz
     */
    public EditQuizInputData(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    /**
     * A getter method
     *
     * @return a string representing the name of the quiz to be changed
     */
    public String getOldName() {
        return oldName;
    }

    /**
     * A getter function
     *
     * @return a string representing the new name of the quiz
     */
    public String getNewName() {
        return newName;
    }
}
