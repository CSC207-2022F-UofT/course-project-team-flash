/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 */

package delete_quiz;

/**
 * This file contains an interface named DeleteQuizOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */
public interface DeleteQuizOutputBoundary {

    void prepareSuccessView(DeleteQuizOutputData outputData);

    void prepareFailView(DeleteQuizOutputData outputData);
}