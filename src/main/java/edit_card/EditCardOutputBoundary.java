/*
 * Author: Albert Yan
 * Date: October 31/22
 * The output boundary for edit card systems
 */
package edit_card;

/**
 * This file contains an interface named EditCardOutputBoundary.
 * It has two abstract methods named prepareSuccessView and prepareFailView.
 */
public interface EditCardOutputBoundary {

    void prepareSuccessView(EditCardOutputData editCardOutputData);
    void prepareFailView(EditCardOutputData editCardOutputData);
}
