/*
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */
package createCard;

/**
 * This file contains an interface named CreateCardOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */
public interface CreateCardOutputBoundary {
    void prepareSuccessView(CreateCardOutputData outputData);
    void prepareFailView(CreateCardOutputData outputData);
}
