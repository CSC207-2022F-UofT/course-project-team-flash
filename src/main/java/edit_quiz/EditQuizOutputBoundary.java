/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * Interface for the EditQuizPresenter.
 */
package edit_quiz;

public interface EditQuizOutputBoundary {
    void prepareSuccessView(EditQuizOutputData outputData);

    void prepareFailView(EditQuizOutputData outputData);
}
