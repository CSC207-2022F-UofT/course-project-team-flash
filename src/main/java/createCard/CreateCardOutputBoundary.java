/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains an interface named CreateCardOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */
package createCard;

public interface CreateCardOutputBoundary {
    void prepareSuccessView(CreateCardOutputData outputData);
    void prepareFailView(CreateCardOutputData outputData);
}
