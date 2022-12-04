/*
 * Author: Derrick Cho
 * Date: November 13/22
 */

package moveCard;

/**
 * This file contains an interface named MoveCardOutputBoundary
 * It has two abstract methods prepareSuccessView and prepareFailView
 */
public interface MoveCardOutputBoundary {

    void prepareSuccessView(MoveCardOutputData moveCardOutputData);

    void prepareFailView(MoveCardOutputData moveCardOutputData);
}
