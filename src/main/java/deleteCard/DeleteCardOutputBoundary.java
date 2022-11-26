package deleteCard;
/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardOutputBoundary
 */

/**
 * This file contains the interface named DeleteCardOutputBoundary and two abstract methods
 * prepareSuccessView and prepareFailView
 */
public interface DeleteCardOutputBoundary {

    public void prepareSuccessView(DeleteCardOutputData deleteCardOutputData);

    public void prepareFailView(DeleteCardOutputData deleteCardOutputData);
}
