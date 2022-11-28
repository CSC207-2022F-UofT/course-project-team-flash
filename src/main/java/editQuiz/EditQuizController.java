/*
 * Author: Andrew Nguyen
 * Date: November 25/22
 * Controller for edit quiz
 */

package editQuiz;

public class EditQuizController {

    private final EditQuizInputBoundary inputBoundary;

    /**
     * Creates a new EditQuizController with the given input boundary.
     *
     * @param inputBoundary The interactor that implements the given inputBoundary
     */
    public EditQuizController(EditQuizInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     *
     *
     * @param oldName the name of the quiz to be changed
     * @param newName the new name of the quiz
     */
    public void edit(String oldName, String newName) {
        EditQuizInputData inputData = new EditQuizInputData(oldName, newName);

        inputBoundary.edit(inputData);
    }
}
