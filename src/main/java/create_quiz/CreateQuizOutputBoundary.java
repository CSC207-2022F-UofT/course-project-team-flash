/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 */

package create_quiz;

/**
 * This file contains an interface named CreateQuizOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */
public interface CreateQuizOutputBoundary {

    void prepareSuccessView(CreateQuizOutputData outputData);

    void prepareFailView(CreateQuizOutputData outputData);
}