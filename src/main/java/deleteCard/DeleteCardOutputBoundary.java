/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardOutputBoundary
 */
package deleteCard;

/**
 * This file contains the interface named DeleteCardOutputBoundary and two abstract methods
 * prepareSuccessView and prepareFailView
 */
public interface DeleteCardOutputBoundary {

    void prepareSuccessView(DeleteCardOutputData deleteCardOutputData);

    void prepareFailView(DeleteCardOutputData deleteCardOutputData);
}
