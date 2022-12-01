/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package editDeck;

public interface EditDeckOutputBoundary {
    /**
     * Prepares view if deck edit was a success.
     * @param outputData data created by the interactor
     */
    void prepareSuccessView(EditDeckOutputData outputData);

    /**
     * Prepares view if deck edit was a failure.
     * @param editDeckOutputData data created by the interactor
     */
    void prepareFailView(EditDeckOutputData editDeckOutputData);
}
