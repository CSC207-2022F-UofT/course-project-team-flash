/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */

package createDeck;

/**
 * This file contains an interface named CreateDeckOutputBoundary.
 * It has two abstract methods named prepareSuccessView and prepareFailView.
 */
public interface CreateDeckOutputBoundary {
    void prepareSuccessView(CreateDeckOutputData outputData);

    void prepareFailView(CreateDeckOutputData outputData);
}