package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

public interface EditDeckOutputBoundary {
    void prepareSuccessView(EditDeckOutputData outputData);

    void prepareFailView(EditDeckOutputData editDeckOutputData);
}
